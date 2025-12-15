// Generated from d:/sara/trabajos/UNIOVI/TERCERO/erasmus/asignaturas/dlp/compilers/Compiler-Implementation-for-VYPlanguage-Programming-Language/src/main/antlr4/VYP.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link VYPParser}.
 */
public interface VYPListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link VYPParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(VYPParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link VYPParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(VYPParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link VYPParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(VYPParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link VYPParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(VYPParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link VYPParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(VYPParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link VYPParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(VYPParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link VYPParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(VYPParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link VYPParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(VYPParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link VYPParser#functionCallStmt}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallStmt(VYPParser.FunctionCallStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link VYPParser#functionCallStmt}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallStmt(VYPParser.FunctionCallStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link VYPParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(VYPParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VYPParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(VYPParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VYPParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(VYPParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link VYPParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(VYPParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link VYPParser#localVarDecl}.
	 * @param ctx the parse tree
	 */
	void enterLocalVarDecl(VYPParser.LocalVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link VYPParser#localVarDecl}.
	 * @param ctx the parse tree
	 */
	void exitLocalVarDecl(VYPParser.LocalVarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link VYPParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(VYPParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link VYPParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(VYPParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link VYPParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(VYPParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link VYPParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(VYPParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link VYPParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(VYPParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link VYPParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(VYPParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link VYPParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(VYPParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link VYPParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(VYPParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link VYPParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(VYPParser.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link VYPParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(VYPParser.ExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link VYPParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(VYPParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link VYPParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(VYPParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link VYPParser#logicalOrExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpr(VYPParser.LogicalOrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link VYPParser#logicalOrExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpr(VYPParser.LogicalOrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link VYPParser#logicalAndExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpr(VYPParser.LogicalAndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link VYPParser#logicalAndExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpr(VYPParser.LogicalAndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link VYPParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpr(VYPParser.EqualityExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link VYPParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpr(VYPParser.EqualityExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link VYPParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(VYPParser.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link VYPParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(VYPParser.RelationalExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link VYPParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(VYPParser.AdditiveExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link VYPParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(VYPParser.AdditiveExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link VYPParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpr(VYPParser.MultiplicativeExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link VYPParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpr(VYPParser.MultiplicativeExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link VYPParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(VYPParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link VYPParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(VYPParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExpr}
	 * labeled alternative in {@link VYPParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpr(VYPParser.FunctionCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExpr}
	 * labeled alternative in {@link VYPParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpr(VYPParser.FunctionCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link VYPParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(VYPParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link VYPParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(VYPParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intLiteral}
	 * labeled alternative in {@link VYPParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterIntLiteral(VYPParser.IntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intLiteral}
	 * labeled alternative in {@link VYPParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitIntLiteral(VYPParser.IntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link VYPParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(VYPParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link VYPParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(VYPParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varRef}
	 * labeled alternative in {@link VYPParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterVarRef(VYPParser.VarRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varRef}
	 * labeled alternative in {@link VYPParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitVarRef(VYPParser.VarRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link VYPParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(VYPParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link VYPParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(VYPParser.ArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link VYPParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(VYPParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link VYPParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(VYPParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link VYPParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(VYPParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link VYPParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(VYPParser.PrimitiveTypeContext ctx);
}