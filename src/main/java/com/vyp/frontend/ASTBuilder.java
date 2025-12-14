package com.vyp.frontend;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import com.vyp.frontend.antlr4.VYPBaseVisitor;
import com.vyp.frontend.antlr4.VYPParser;
import com.vyp.frontend.ast.ASTNode;
import com.vyp.frontend.ast.FunctionDecl;
import com.vyp.frontend.ast.Parameter;
import com.vyp.frontend.ast.Program;
import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ast.expr.BinaryOp;
import com.vyp.frontend.ast.expr.Expression;
import com.vyp.frontend.ast.expr.FunctionCallExpr;
import com.vyp.frontend.ast.expr.IntLiteral;
import com.vyp.frontend.ast.expr.StringLiteral;
import com.vyp.frontend.ast.expr.UnaryOp;
import com.vyp.frontend.ast.expr.Var;
import com.vyp.frontend.ast.stmt.AssignStmt;
import com.vyp.frontend.ast.stmt.BlockStmt;
import com.vyp.frontend.ast.stmt.ExprStmt;
import com.vyp.frontend.ast.stmt.IfStmt;
import com.vyp.frontend.ast.stmt.ReturnStmt;
import com.vyp.frontend.ast.stmt.Statement;
import com.vyp.frontend.ast.stmt.VarDeclStmt;
import com.vyp.frontend.ast.stmt.WhileStmt;
import com.vyp.semantic.type.IntType;
import com.vyp.semantic.type.StringType;
import com.vyp.semantic.type.Type;
import com.vyp.semantic.type.VoidType;

public class ASTBuilder extends VYPBaseVisitor<Object> {

    private SourceLocation getLocation(ParserRuleContext prctx) {
        Token t = prctx.getStart();
        return new SourceLocation(t.getLine(), t.getCharPositionInLine());
    }

    private SourceLocation getLocation(Token token) {
        return new SourceLocation(token.getLine(), token.getCharPositionInLine());
    }

    @Override
    public Program visitProgram(VYPParser.ProgramContext ctx) {
        List<FunctionDecl> functions = new ArrayList<>();
        for (VYPParser.FunctionDeclContext fctx : ctx.functionDecl()) {
            functions.add((FunctionDecl) visit(fctx));
        }
        return new Program(functions, getLocation(ctx));
    }

    @Override
    public FunctionDecl visitFunctionDecl(VYPParser.FunctionDeclContext ctx) {
        String name = ctx.IDENT().getText();
        Type returnType = (Type) visit(ctx.type());
        List<Parameter> params = new ArrayList<>();
        if (ctx.paramList() != null) {
            for (VYPParser.ParamContext pctx : ctx.paramList().param()) {
                params.add((Parameter) visit(pctx));
            }
        }
        BlockStmt body = (BlockStmt) visit(ctx.block());
        return new FunctionDecl(name, returnType, params, body, getLocation(ctx));
    }

    @Override
    public Parameter visitParam(VYPParser.ParamContext ctx) {
        String name = ctx.IDENT().getText();
        // param: DATA_TYPE IDENT;
        Type type = ctx.DATA_TYPE() != null && "int".equals(ctx.DATA_TYPE().getText()) ? IntType.INSTANCE : StringType.INSTANCE;
        return new Parameter(name, type, getLocation(ctx));
    }

    @Override
    public Type visitType(VYPParser.TypeContext ctx) {
        if (ctx.DATA_TYPE() != null) {
            String dt = ctx.DATA_TYPE().getText();
            if ("int".equals(dt)) return IntType.INSTANCE;
            if ("string".equals(dt)) return StringType.INSTANCE;
        }
        if (ctx.VOID() != null) return VoidType.INSTANCE;
        return VoidType.INSTANCE;
    }

    @Override
    public BlockStmt visitBlock(VYPParser.BlockContext ctx) {
        List<Statement> stmts = new ArrayList<>();
        for (VYPParser.StatementContext sctx : ctx.statement()) {
            stmts.add((Statement) visit(sctx));
        }
        return new BlockStmt(stmts, getLocation(ctx));
    }

    @Override
    public Statement visitStatement(VYPParser.StatementContext ctx) {
        return (Statement) visitChildren(ctx);
    }

    @Override
    public VarDeclStmt visitLocalVarDecl(VYPParser.LocalVarDeclContext ctx) {
        Type type = ctx.DATA_TYPE() != null && "int".equals(ctx.DATA_TYPE().getText()) ? IntType.INSTANCE : StringType.INSTANCE;
        List<String> names = new ArrayList<>();
        for (TerminalNode id : ctx.IDENT()) {
            names.add(id.getText());
        }
        return new VarDeclStmt(type, names, getLocation(ctx));
    }

    @Override
    public AssignStmt visitAssignStmt(VYPParser.AssignStmtContext ctx) {
        String name = ctx.IDENT().getText();
        Expression value = (Expression) visit(ctx.expr());
        return new AssignStmt(name, value, getLocation(ctx));
    }

    @Override
    public IfStmt visitIfStmt(VYPParser.IfStmtContext ctx) {
        Expression cond = (Expression) visit(ctx.expr());
        BlockStmt thenBlock = (BlockStmt) visit(ctx.block(0));
        BlockStmt elseBlock = ctx.block().size() > 1 ? (BlockStmt) visit(ctx.block(1)) : null;
        return new IfStmt(cond, thenBlock, elseBlock, getLocation(ctx));
    }

    @Override
    public WhileStmt visitWhileStmt(VYPParser.WhileStmtContext ctx) {
        Expression cond = (Expression) visit(ctx.expr());
        BlockStmt body = (BlockStmt) visit(ctx.block());
        return new WhileStmt(cond, body, getLocation(ctx));
    }

    @Override
    public ReturnStmt visitReturnStmt(VYPParser.ReturnStmtContext ctx) {
        Expression value = ctx.expr() != null ? (Expression) visit(ctx.expr()) : null;
        return new ReturnStmt(value, getLocation(ctx));
    }

    @Override
    public ExprStmt visitExprStmt(VYPParser.ExprStmtContext ctx) {
        Expression expr = (Expression) visit(ctx.expr());
        return new ExprStmt(expr, getLocation(ctx));
    }

    @Override
    public Expression visitExpr(VYPParser.ExprContext ctx) {
        return (Expression) visit(ctx.logicalOrExpr());
    }

    @Override
    public Expression visitLogicalOrExpr(VYPParser.LogicalOrExprContext ctx) {
        if (ctx.logicalAndExpr().size() == 1) {
            return (Expression) visit(ctx.logicalAndExpr(0));
        }
        // Handle OR chain, but for simplicity, assume left assoc
        Expression left = (Expression) visit(ctx.logicalAndExpr(0));
        for (int i = 1; i < ctx.logicalAndExpr().size(); i++) {
            Expression right = (Expression) visit(ctx.logicalAndExpr(i));
            left = new BinaryOp(left, right, BinaryOp.BinaryOperator.OR, getLocation(ctx));
        }
        return left;
    }

    @Override
    public Expression visitLogicalAndExpr(VYPParser.LogicalAndExprContext ctx) {
        if (ctx.equalityExpr().size() == 1) {
            return (Expression) visit(ctx.equalityExpr(0));
        }
        Expression left = (Expression) visit(ctx.equalityExpr(0));
        for (int i = 1; i < ctx.equalityExpr().size(); i++) {
            Expression right = (Expression) visit(ctx.equalityExpr(i));
            left = new BinaryOp(left, right, BinaryOp.BinaryOperator.AND, getLocation(ctx));
        }
        return left;
    }

    @Override
    public Expression visitEqualityExpr(VYPParser.EqualityExprContext ctx) {
        if (ctx.relationalExpr().size() == 1) {
            return (Expression) visit(ctx.relationalExpr(0));
        }
        Expression left = (Expression) visit(ctx.relationalExpr(0));
        for (int i = 1; i < ctx.relationalExpr().size(); i++) {
            Expression right = (Expression) visit(ctx.relationalExpr(i));
            BinaryOp.BinaryOperator op = ctx.EQ(i-1) != null ? BinaryOp.BinaryOperator.EQ :
                                         ctx.NEQ(i-1) != null ? BinaryOp.BinaryOperator.NEQ : null;
            left = new BinaryOp(left, right, op, getLocation(ctx));
        }
        return left;
    }

    @Override
    public Expression visitRelationalExpr(VYPParser.RelationalExprContext ctx) {
        if (ctx.additiveExpr().size() == 1) {
            return (Expression) visit(ctx.additiveExpr(0));
        }
        Expression left = (Expression) visit(ctx.additiveExpr(0));
        for (int i = 1; i < ctx.additiveExpr().size(); i++) {
            Expression right = (Expression) visit(ctx.additiveExpr(i));
            BinaryOp.BinaryOperator op = ctx.LT(i-1) != null ? BinaryOp.BinaryOperator.LT :
                                         ctx.LTE(i-1) != null ? BinaryOp.BinaryOperator.LTE :
                                         ctx.GT(i-1) != null ? BinaryOp.BinaryOperator.GT :
                                         ctx.GTE(i-1) != null ? BinaryOp.BinaryOperator.GTE : null;
            left = new BinaryOp(left, right, op, getLocation(ctx));
        }
        return left;
    }

    @Override
    public Expression visitAdditiveExpr(VYPParser.AdditiveExprContext ctx) {
        if (ctx.multiplicativeExpr().size() == 1) {
            return (Expression) visit(ctx.multiplicativeExpr(0));
        }
        Expression left = (Expression) visit(ctx.multiplicativeExpr(0));
        for (int i = 1; i < ctx.multiplicativeExpr().size(); i++) {
            Expression right = (Expression) visit(ctx.multiplicativeExpr(i));
            BinaryOp.BinaryOperator op = ctx.PLUS(i-1) != null ? BinaryOp.BinaryOperator.ADD :
                                         ctx.MINUS(i-1) != null ? BinaryOp.BinaryOperator.SUB : null;
            left = new BinaryOp(left, right, op, getLocation(ctx));
        }
        return left;
    }

    @Override
    public Expression visitMultiplicativeExpr(VYPParser.MultiplicativeExprContext ctx) {
        if (ctx.unaryExpr().size() == 1) {
            return (Expression) visit(ctx.unaryExpr(0));
        }
        Expression left = (Expression) visit(ctx.unaryExpr(0));
        for (int i = 1; i < ctx.unaryExpr().size(); i++) {
            Expression right = (Expression) visit(ctx.unaryExpr(i));
            BinaryOp.BinaryOperator op = ctx.STAR(i-1) != null ? BinaryOp.BinaryOperator.MUL :
                                         ctx.SLASH(i-1) != null ? BinaryOp.BinaryOperator.DIV : null;
            left = new BinaryOp(left, right, op, getLocation(ctx));
        }
        return left;
    }

    @Override
    public Expression visitUnaryExpr(VYPParser.UnaryExprContext ctx) {
        if (ctx.NOT() != null) {
            Expression inner = (Expression) visit(ctx.unaryExpr());
            return new UnaryOp(inner, UnaryOp.UnaryOperator.NOT, getLocation(ctx));
        }
        return (Expression) visit(ctx.primaryExpr());
    }
    @Override
    public Expression visitFunctionCallExpr(VYPParser.FunctionCallExprContext ctx) {
        String fname = ctx.IDENT().getText();
        List<Expression> args = new ArrayList<>();
        if (ctx.argList() != null) {
            for (VYPParser.ExprContext ectx : ctx.argList().expr()) {
                args.add((Expression) visit(ectx));
            }
        }
        return new FunctionCallExpr(fname, args, getLocation(ctx));
    }

    @Override
    public Expression visitParenExpr(VYPParser.ParenExprContext ctx) {
        return (Expression) visit(ctx.expr());
    }

    @Override
    public Expression visitIntLiteral(VYPParser.IntLiteralContext ctx) {
        int val = Integer.parseInt(ctx.INT_LITERAL().getText());
        return new IntLiteral(val, getLocation(ctx));
    }

    @Override
    public Expression visitStringLiteral(VYPParser.StringLiteralContext ctx) {
        String text = ctx.STRING_LITERAL().getText();
        text = text.substring(1, text.length() - 1);
        return new StringLiteral(text, getLocation(ctx));
    }

    @Override
    public Expression visitVarRef(VYPParser.VarRefContext ctx) {
        return new Var(ctx.IDENT().getText(), getLocation(ctx));
    }
}
