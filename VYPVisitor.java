// Generated from src/main/antlr4/VYP.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link VYPParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface VYPVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link VYPParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(VYPParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link VYPParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(VYPParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link VYPParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(VYPParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link VYPParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(VYPParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link VYPParser#functionCallStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallStmt(VYPParser.FunctionCallStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link VYPParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(VYPParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link VYPParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(VYPParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link VYPParser#localVarDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVarDecl(VYPParser.LocalVarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link VYPParser#assignStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmt(VYPParser.AssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link VYPParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(VYPParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link VYPParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(VYPParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link VYPParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(VYPParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link VYPParser#exprStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmt(VYPParser.ExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link VYPParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(VYPParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link VYPParser#logicalOrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpr(VYPParser.LogicalOrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link VYPParser#logicalAndExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpr(VYPParser.LogicalAndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link VYPParser#equalityExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(VYPParser.EqualityExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link VYPParser#relationalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(VYPParser.RelationalExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link VYPParser#additiveExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(VYPParser.AdditiveExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link VYPParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpr(VYPParser.MultiplicativeExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link VYPParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(VYPParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallExpr}
	 * labeled alternative in {@link VYPParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpr(VYPParser.FunctionCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link VYPParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(VYPParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intLiteral}
	 * labeled alternative in {@link VYPParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteral(VYPParser.IntLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link VYPParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(VYPParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varRef}
	 * labeled alternative in {@link VYPParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarRef(VYPParser.VarRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link VYPParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(VYPParser.ArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link VYPParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(VYPParser.TypeContext ctx);
}