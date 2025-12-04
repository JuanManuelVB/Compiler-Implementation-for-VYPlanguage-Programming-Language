// Generated from VYP.g4 by ANTLR 4.9.3
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
	 * Enter a parse tree produced by {@link VYPParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(VYPParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link VYPParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(VYPParser.ExprContext ctx);
}