package com.vyp.frontend;

import com.vyp.frontend.ast.*;
import com.vyp.frontend.ast.expr.*;
import com.vyp.frontend.ast.stmt.*;
import com.vyp.semantic.type.*;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.VYPParser;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.List;

public class ASTBuilder extends VYPBaseVisitor<ASTNode> {

    /**
     * Get source location from parser rule context. Traslates line and column from antlr to our
     * SourceLocation class.
     * @param prctx
     * @return
     */
    private SourceLocation getLocation(ParserRuleContext prctx) {
        Token t = prctx.getStart();
        return new SourceLocation(t.getLine(), t.getCharPositionInLine());
    }

    private SourceLocation getLocation(Token token) {
        return new SourceLocation(token.getLine(), token.getCharPositionInLine());
    }

    /**
     * Helper method to get location. IT calls getLocation with the start token of the context.
     * @param pctx
     * @return
     */
    @Override
    public Program visitProgram(VYPParser.ProgramContext pctx) {
        List<FunctionDecl> functions = new ArrayList<>();

        for (VYPParser.FunctionDeclContext fctx : pctx.functionDecl()) {
            functions.add((FunctionDecl) visit(fctx));
        }

        return new Program(functions, getLocation(pctx));
    }

    /**
     * Visit function declaration
     * @param fctx
     * @return
     */
    @Override
    public FunctionDecl visitFunctionDecl(VYPParser.FunctionDeclContext fctx) {
        String name = fctx.ID().getText();

        // tipo return
        Type returnType = (Type) visit(fctx.type());

        // parámetros
        List<Parameter> Parameters = new ArrayList<>();
        if (fctx.ParameterList() != null) {
            for (VYPParser.ParameterContext pctx : fctx.ParameterList().Parameter()) {
                Parameters.add((Parameter) visit(pctx));
            }
        }

        BlockStmt body = (BlockStmt) visit(fctx.block());

        return new FunctionDecl(name, returnType, Parameters, body, getLocation(fctx));
    }

    /**
     * Visit and constructs parameter
     * @param paramctx
     * @return
     */
    @Override
    public Parameter visitParameter(VYPParser.ParameterContext paramctx) {
        String name = paramctx.ID().getText();
        Type t = (Type) visit(paramctx.type());
        return new Parameter(name, t, getLocation(paramctx));
    }

    /**
     * Visit type
     * @param ctx
     * @return
     */
    @Override
    public Type visitType(VYPParser.TypeContext tctx) {
        if (tctx.INT() != null) return IntType.INSTANCE;
        if (tctx.STRING() != null) return StringType.INSTANCE;
        return VoidType.INSTANCE;
    }

    /**
     * Visit block statement, converting  { stmt1 ; stmt2 ; ... } in a BlockStmt with a statement list.
     * @param ctx
     * @return
     */
    @Override
    public BlockStmt visitBlock(VYPParser.BlockContext bctx) {
        List<Statement> stmts = new ArrayList<>();
        for (VYPParser.StatementContext sctx : bctx.statement()) {
            stmts.add((Statement) visit(sctx));
        }
        return new BlockStmt(stmts, getLocation(bctx));
    }

    /**
     * Each antlr statement is converted to a Statement node of my AST tree by visiting it.
     * @param ctx
     * @return
     */
    @Override
    public Statement visitStatement(VYPParser.StatementContext sctx) {
        return (Statement) visitChildren(sctx);
    }

    @Override
    public VarDeclStmt visitVarDeclStatement(VYPParser.VarDeclContext varctx) {
        Type t = (Type) visit(varctx.type());
        List<String> names = new ArrayList<>();

        for (Token id : varctx.ID()) {
            names.add(id.getText());
        }

        return new VarDeclStmt(t, names, getLocation(varctx));
    }

    @Override
    public AssignStmt visitAssignStatement(VYPParser.AssignStatContext actx) {
        String name = actx.ID().getText();
        Expression value = (Expression) visit(actx.expr());
        return new AssignStmt(name, value, getLocation(actx));
    }

    @Override
    public IfStmt visitIfStatement(VYPParser.IfStatContext ifctx) {
        Expression cond = (Expression) visit(ifctx.expr());
        BlockStmt thenBlock = (BlockStmt) visit(ifctx.block(0));
        BlockStmt elseBlock = ifctx.block().size() > 1
                ? (BlockStmt) visit(ifctx.block(1))
                : null;

        return new IfStmt(cond, thenBlock, elseBlock, getLocation(ifctx));
    }

    @Override
    public WhileStmt visitWhileStatement(VYPParser.WhenStatContext whenctx) {
        Expression cond = (Expression) visit(whenctx.expr());
        BlockStmt body = (BlockStmt) visit(whenctx.block());
        return new WhileStmt(cond, body, getLocation(whenctx));
    }

    @Override
    public ReturnStmt visitReturnStatement(VYPParser.ReturnStatContext retctx) {
        Expression value = retctx.expr() != null ? (Expression) visit(retctx.expr()) : null;
        return new ReturnStmt(value, getLocation(retctx));
    }

    @Override
    public ExprStmt visitExprStatement(VYPParser.ExprStatContext exprctx) {
        Expression expr = (Expression) visit(exprctx.expr());
        return new ExprStmt(expr, getLocation(exprctx));
    }

    /**
     * Construct atomic expressions: int literals, string literals, variable references and parenthesized expressions, 
     * from the antlr parse tree to my AST tree.
     * @param ctx
     * @return
     */
    @Override
    public Expression visitExpr(VYPParser.AtomExprContext atomctx) {
        if (atomctx.INT_LITERAL() != null) {
            int val = Integer.parseInt(atomctx.INT_LITERAL().getText());
            return new IntLiteral(val, getLocation(atomctx));
        }

        if (atomctx.STRING_LITERAL() != null) {
            String text = atomctx.STRING_LITERAL().getText();
            text = text.substring(1, text.length()-1); // quitar comillas
            return new StringLiteral(text, getLocation(atomctx));
        }

        if (atomctx.ID() != null) {
            return new Var(atomctx.ID().getText(), getLocation(atomctx));
        }

        // (expr)
        return (Expression) visit(atomctx.expr());
    }

    @Override
    public Expression visitCallExpr(VYPParser.CallExprContext callctx) {

        String fname = callctx.ID().getText();
        List<Expression> args = new ArrayList<>();

        if (callctx.argList() != null) {
            for (VYPParser.ExprContext ectx : callctx.argList().expr()) {
                args.add((Expression) visit(ectx));
            }
        }

        return new FunctionCallExpr(fname, args, getLocation(callctx));
    }

    @Override
    public Expression visitBinMulExpr(VYPParser.MulExprContext binctx) {
        if (binctx.op == null)
            return (Expression) visit(binctx.unaryExpr(0));

        Expression left = (Expression) visit(binctx.unaryExpr(0));
        Expression right = (Expression) visit(binctx.unaryExpr(1));
        BinaryOp op =
            binctx.MUL() != null ? BinaryOp.BinaryOperator.MUL :
            binctx.DIV() != null ? BinaryOp.BinaryOperator.DIV :
            null;

        return new BinaryOp(left, right, op, getLocation(binctx));
    }

    @Override
    public Expression visitBinAddExpr(VYPParser.AddExprContext binctx) {
        if (binctx.op == null)
            return (Expression) visit(binctx.mulExpr(0));

        Expression left = (Expression) visit(binctx.mulExpr(0));
        Expression right = (Expression) visit(binctx.mulExpr(1));

        BinaryOperator op =
            binctx.ADD() != null ? BinaryOp.BinaryOperator.ADD :
            binctx.SUB() != null ? BinaryOp.BinaryOperator.SUB :
            null;

        return new BinaryOp(left, right, op, getLocation(binctx));
    }

    @Override
    public Expression visitUnaryExpr(VYPParser.UnaryExprContext unctx) {
        if (unctx.NOT() != null) {
            Expression inner = (Expression) visit(unctx.unaryExpr());
            return new UnaryOp(UnaryOp.UnaryOperator.NOT, inner, loc(unctx));
        }
        return (Expression) visit(unctx.atomExpr());
    }

    @Override
    public Expression visitParenExpr(VYPParser.ParenExprContext ctx) {
        return (Expression) visit(ctx.expr());
    }

}
