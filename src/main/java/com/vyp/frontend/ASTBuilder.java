package com.vyp.frontend;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import com.vyp.antlr4.VYPBaseVisitor;
import com.vyp.antlr4.VYPParser;
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

public class ASTBuilder extends VYPBaseVisitor<ASTNode> {

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
        String name = ctx.ID().getText();
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
        String name = ctx.ID().getText();
        Type type = (Type) visit(ctx.type());
        return new Parameter(name, type, getLocation(ctx));
    }

    @Override
    public Type visitType(VYPParser.TypeContext ctx) {
        if (ctx.INT() != null) return IntType.INSTANCE;
        if (ctx.STRING() != null) return StringType.INSTANCE;
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
        Type type = (Type) visit(ctx.type());
        List<String> names = new ArrayList<>();
        for (Token id : ctx.ID()) {
            names.add(id.getText());
        }
        return new VarDeclStmt(type, names, getLocation(ctx));
    }

    @Override
    public AssignStmt visitAssignStmt(VYPParser.AssignStmtContext ctx) {
        String name = ctx.ID().getText();
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
                                         ctx.NE(i-1) != null ? BinaryOp.BinaryOperator.NE : null;
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
                                         ctx.LE(i-1) != null ? BinaryOp.BinaryOperator.LE :
                                         ctx.GT(i-1) != null ? BinaryOp.BinaryOperator.GT :
                                         ctx.GE(i-1) != null ? BinaryOp.BinaryOperator.GE : null;
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
            BinaryOp.BinaryOperator op = ctx.ADD(i-1) != null ? BinaryOp.BinaryOperator.ADD :
                                         ctx.SUB(i-1) != null ? BinaryOp.BinaryOperator.SUB : null;
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
            BinaryOp.BinaryOperator op = ctx.MUL(i-1) != null ? BinaryOp.BinaryOperator.MUL :
                                         ctx.DIV(i-1) != null ? BinaryOp.BinaryOperator.DIV : null;
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
        return (Expression) visit(ctx.atomExpr());
    }

    @Override
    public Expression visitAtomExpr(VYPParser.AtomExprContext ctx) {
        if (ctx.INT_LITERAL() != null) {
            int val = Integer.parseInt(ctx.INT_LITERAL().getText());
            return new IntLiteral(val, getLocation(ctx));
        }
        if (ctx.STRING_LITERAL() != null) {
            String text = ctx.STRING_LITERAL().getText();
            text = text.substring(1, text.length() - 1);
            return new StringLiteral(text, getLocation(ctx));
        }
        if (ctx.ID() != null && ctx.LPAREN() == null) {
            return new Var(ctx.ID().getText(), getLocation(ctx));
        }
        if (ctx.LPAREN() != null) {
            return (Expression) visit(ctx.expr());
        }
        // Function call
        if (ctx.ID() != null && ctx.LPAREN() != null) {
            String fname = ctx.ID().getText();
            List<Expression> args = new ArrayList<>();
            if (ctx.argList() != null) {
                for (VYPParser.ExprContext ectx : ctx.argList().expr()) {
                    args.add((Expression) visit(ectx));
                }
            }
            return new FunctionCallExpr(fname, args, getLocation(ctx));
        }
        return null; // Error
    }
}
