// Generated from VYP.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class VYPParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ELSE=1, IF=2, INT=3, RETURN=4, STRING=5, VOID=6, WHILE=7, LPAREN=8, RPAREN=9, 
		LBRACE=10, RBRACE=11, COMMA=12, SEMI=13, COLON=14, ASSIGN=15, NOT=16, 
		STAR=17, SLASH=18, PLUS=19, MINUS=20, LTE=21, GTE=22, LT=23, GT=24, EQ=25, 
		NEQ=26, AND=27, OR=28, INT_LITERAL=29, STRING_LITERAL=30, IDENT=31, WS=32, 
		LINE_COMMENT=33, BLOCK_COMMENT=34, DATA_TYPE=35;
	public static final int
		RULE_program = 0, RULE_functionDecl = 1, RULE_paramList = 2, RULE_param = 3, 
		RULE_functionCallStmt = 4, RULE_statement = 5, RULE_block = 6, RULE_localVarDecl = 7, 
		RULE_assignStmt = 8, RULE_ifStmt = 9, RULE_whileStmt = 10, RULE_returnStmt = 11, 
		RULE_exprStmt = 12, RULE_expr = 13, RULE_logicalOrExpr = 14, RULE_logicalAndExpr = 15, 
		RULE_equalityExpr = 16, RULE_relationalExpr = 17, RULE_additiveExpr = 18, 
		RULE_multiplicativeExpr = 19, RULE_unaryExpr = 20, RULE_primaryExpr = 21, 
		RULE_argList = 22, RULE_type = 23, RULE_primitiveType = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "functionDecl", "paramList", "param", "functionCallStmt", 
			"statement", "block", "localVarDecl", "assignStmt", "ifStmt", "whileStmt", 
			"returnStmt", "exprStmt", "expr", "logicalOrExpr", "logicalAndExpr", 
			"equalityExpr", "relationalExpr", "additiveExpr", "multiplicativeExpr", 
			"unaryExpr", "primaryExpr", "argList", "type", "primitiveType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'else'", "'if'", "'int'", "'return'", "'string'", "'void'", "'while'", 
			"'('", "')'", "'{'", "'}'", "','", "';'", "':'", "'='", "'!'", "'*'", 
			"'/'", "'+'", "'-'", "'<='", "'>='", "'<'", "'>'", "'=='", "'!='", "'&&'", 
			"'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ELSE", "IF", "INT", "RETURN", "STRING", "VOID", "WHILE", "LPAREN", 
			"RPAREN", "LBRACE", "RBRACE", "COMMA", "SEMI", "COLON", "ASSIGN", "NOT", 
			"STAR", "SLASH", "PLUS", "MINUS", "LTE", "GTE", "LT", "GT", "EQ", "NEQ", 
			"AND", "OR", "INT_LITERAL", "STRING_LITERAL", "IDENT", "WS", "LINE_COMMENT", 
			"BLOCK_COMMENT", "DATA_TYPE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "VYP.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public VYPParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(VYPParser.EOF, 0); }
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << INT) | (1L << RETURN) | (1L << STRING) | (1L << VOID) | (1L << WHILE) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMI) | (1L << NOT) | (1L << MINUS) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENT) | (1L << DATA_TYPE))) != 0)) {
				{
				setState(52);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT:
				case STRING:
				case VOID:
					{
					setState(50);
					functionDecl();
					}
					break;
				case IF:
				case RETURN:
				case WHILE:
				case LPAREN:
				case LBRACE:
				case SEMI:
				case NOT:
				case MINUS:
				case INT_LITERAL:
				case STRING_LITERAL:
				case IDENT:
				case DATA_TYPE:
					{
					setState(51);
					statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(VYPParser.IDENT, 0); }
		public TerminalNode LPAREN() { return getToken(VYPParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(VYPParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public TerminalNode VOID() { return getToken(VYPParser.VOID, 0); }
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitFunctionDecl(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_functionDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			type();
			setState(60);
			match(IDENT);
			setState(61);
			match(LPAREN);
			setState(64);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case STRING:
				{
				setState(62);
				paramList();
				}
				break;
			case VOID:
				{
				setState(63);
				match(VOID);
				}
				break;
			case RPAREN:
				break;
			default:
				break;
			}
			setState(66);
			match(RPAREN);
			setState(67);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamListContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(VYPParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(VYPParser.COMMA, i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitParamList(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			param();
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(70);
				match(COMMA);
				setState(71);
				param();
				}
				}
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(VYPParser.IDENT, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			primitiveType();
			setState(78);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallStmtContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(VYPParser.IDENT, 0); }
		public TerminalNode LPAREN() { return getToken(VYPParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(VYPParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(VYPParser.SEMI, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public FunctionCallStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCallStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterFunctionCallStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitFunctionCallStmt(this);
		}
	}

	public final FunctionCallStmtContext functionCallStmt() throws RecognitionException {
		FunctionCallStmtContext _localctx = new FunctionCallStmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionCallStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(IDENT);
			setState(81);
			match(LPAREN);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << NOT) | (1L << MINUS) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENT))) != 0)) {
				{
				setState(82);
				argList();
				}
			}

			setState(85);
			match(RPAREN);
			setState(86);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LocalVarDeclContext localVarDecl() {
			return getRuleContext(LocalVarDeclContext.class,0);
		}
		public AssignStmtContext assignStmt() {
			return getRuleContext(AssignStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public ExprStmtContext exprStmt() {
			return getRuleContext(ExprStmtContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(VYPParser.SEMI, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		try {
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				localVarDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				assignStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(91);
				ifStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(92);
				whileStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(93);
				returnStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(94);
				exprStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(95);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(VYPParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(VYPParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(LBRACE);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << RETURN) | (1L << WHILE) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMI) | (1L << NOT) | (1L << MINUS) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENT) | (1L << DATA_TYPE))) != 0)) {
				{
				{
				setState(99);
				statement();
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(105);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalVarDeclContext extends ParserRuleContext {
		public TerminalNode DATA_TYPE() { return getToken(VYPParser.DATA_TYPE, 0); }
		public List<TerminalNode> IDENT() { return getTokens(VYPParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(VYPParser.IDENT, i);
		}
		public TerminalNode SEMI() { return getToken(VYPParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(VYPParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(VYPParser.COMMA, i);
		}
		public LocalVarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVarDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterLocalVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitLocalVarDecl(this);
		}
	}

	public final LocalVarDeclContext localVarDecl() throws RecognitionException {
		LocalVarDeclContext _localctx = new LocalVarDeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_localVarDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(DATA_TYPE);
			setState(108);
			match(IDENT);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(109);
				match(COMMA);
				setState(110);
				match(IDENT);
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(116);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignStmtContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(VYPParser.IDENT, 0); }
		public TerminalNode ASSIGN() { return getToken(VYPParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(VYPParser.SEMI, 0); }
		public AssignStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterAssignStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitAssignStmt(this);
		}
	}

	public final AssignStmtContext assignStmt() throws RecognitionException {
		AssignStmtContext _localctx = new AssignStmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assignStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(IDENT);
			setState(119);
			match(ASSIGN);
			setState(120);
			expr();
			setState(121);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(VYPParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(VYPParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(VYPParser.RPAREN, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(VYPParser.ELSE, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitIfStmt(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ifStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(IF);
			setState(124);
			match(LPAREN);
			setState(125);
			expr();
			setState(126);
			match(RPAREN);
			setState(127);
			block();
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(128);
				match(ELSE);
				setState(129);
				block();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(VYPParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(VYPParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(VYPParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitWhileStmt(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(WHILE);
			setState(133);
			match(LPAREN);
			setState(134);
			expr();
			setState(135);
			match(RPAREN);
			setState(136);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(VYPParser.RETURN, 0); }
		public TerminalNode SEMI() { return getToken(VYPParser.SEMI, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitReturnStmt(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(RETURN);
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << NOT) | (1L << MINUS) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENT))) != 0)) {
				{
				setState(139);
				expr();
				}
			}

			setState(142);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(VYPParser.SEMI, 0); }
		public ExprStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterExprStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitExprStmt(this);
		}
	}

	public final ExprStmtContext exprStmt() throws RecognitionException {
		ExprStmtContext _localctx = new ExprStmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_exprStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			expr();
			setState(145);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public LogicalOrExprContext logicalOrExpr() {
			return getRuleContext(LogicalOrExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			logicalOrExpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicalOrExprContext extends ParserRuleContext {
		public List<LogicalAndExprContext> logicalAndExpr() {
			return getRuleContexts(LogicalAndExprContext.class);
		}
		public LogicalAndExprContext logicalAndExpr(int i) {
			return getRuleContext(LogicalAndExprContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(VYPParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(VYPParser.OR, i);
		}
		public LogicalOrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOrExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterLogicalOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitLogicalOrExpr(this);
		}
	}

	public final LogicalOrExprContext logicalOrExpr() throws RecognitionException {
		LogicalOrExprContext _localctx = new LogicalOrExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_logicalOrExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			logicalAndExpr();
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(150);
				match(OR);
				setState(151);
				logicalAndExpr();
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicalAndExprContext extends ParserRuleContext {
		public List<EqualityExprContext> equalityExpr() {
			return getRuleContexts(EqualityExprContext.class);
		}
		public EqualityExprContext equalityExpr(int i) {
			return getRuleContext(EqualityExprContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(VYPParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(VYPParser.AND, i);
		}
		public LogicalAndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalAndExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterLogicalAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitLogicalAndExpr(this);
		}
	}

	public final LogicalAndExprContext logicalAndExpr() throws RecognitionException {
		LogicalAndExprContext _localctx = new LogicalAndExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_logicalAndExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			equalityExpr();
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(158);
				match(AND);
				setState(159);
				equalityExpr();
				}
				}
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualityExprContext extends ParserRuleContext {
		public List<RelationalExprContext> relationalExpr() {
			return getRuleContexts(RelationalExprContext.class);
		}
		public RelationalExprContext relationalExpr(int i) {
			return getRuleContext(RelationalExprContext.class,i);
		}
		public List<TerminalNode> EQ() { return getTokens(VYPParser.EQ); }
		public TerminalNode EQ(int i) {
			return getToken(VYPParser.EQ, i);
		}
		public List<TerminalNode> NEQ() { return getTokens(VYPParser.NEQ); }
		public TerminalNode NEQ(int i) {
			return getToken(VYPParser.NEQ, i);
		}
		public EqualityExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterEqualityExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitEqualityExpr(this);
		}
	}

	public final EqualityExprContext equalityExpr() throws RecognitionException {
		EqualityExprContext _localctx = new EqualityExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_equalityExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			relationalExpr();
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EQ || _la==NEQ) {
				{
				{
				setState(166);
				_la = _input.LA(1);
				if ( !(_la==EQ || _la==NEQ) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(167);
				relationalExpr();
				}
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationalExprContext extends ParserRuleContext {
		public List<AdditiveExprContext> additiveExpr() {
			return getRuleContexts(AdditiveExprContext.class);
		}
		public AdditiveExprContext additiveExpr(int i) {
			return getRuleContext(AdditiveExprContext.class,i);
		}
		public List<TerminalNode> LT() { return getTokens(VYPParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(VYPParser.LT, i);
		}
		public List<TerminalNode> LTE() { return getTokens(VYPParser.LTE); }
		public TerminalNode LTE(int i) {
			return getToken(VYPParser.LTE, i);
		}
		public List<TerminalNode> GT() { return getTokens(VYPParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(VYPParser.GT, i);
		}
		public List<TerminalNode> GTE() { return getTokens(VYPParser.GTE); }
		public TerminalNode GTE(int i) {
			return getToken(VYPParser.GTE, i);
		}
		public RelationalExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterRelationalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitRelationalExpr(this);
		}
	}

	public final RelationalExprContext relationalExpr() throws RecognitionException {
		RelationalExprContext _localctx = new RelationalExprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_relationalExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			additiveExpr();
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LTE) | (1L << GTE) | (1L << LT) | (1L << GT))) != 0)) {
				{
				{
				setState(174);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LTE) | (1L << GTE) | (1L << LT) | (1L << GT))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(175);
				additiveExpr();
				}
				}
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditiveExprContext extends ParserRuleContext {
		public List<MultiplicativeExprContext> multiplicativeExpr() {
			return getRuleContexts(MultiplicativeExprContext.class);
		}
		public MultiplicativeExprContext multiplicativeExpr(int i) {
			return getRuleContext(MultiplicativeExprContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(VYPParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(VYPParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(VYPParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(VYPParser.MINUS, i);
		}
		public AdditiveExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterAdditiveExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitAdditiveExpr(this);
		}
	}

	public final AdditiveExprContext additiveExpr() throws RecognitionException {
		AdditiveExprContext _localctx = new AdditiveExprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_additiveExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			multiplicativeExpr();
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(182);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(183);
				multiplicativeExpr();
				}
				}
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplicativeExprContext extends ParserRuleContext {
		public List<UnaryExprContext> unaryExpr() {
			return getRuleContexts(UnaryExprContext.class);
		}
		public UnaryExprContext unaryExpr(int i) {
			return getRuleContext(UnaryExprContext.class,i);
		}
		public List<TerminalNode> STAR() { return getTokens(VYPParser.STAR); }
		public TerminalNode STAR(int i) {
			return getToken(VYPParser.STAR, i);
		}
		public List<TerminalNode> SLASH() { return getTokens(VYPParser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(VYPParser.SLASH, i);
		}
		public MultiplicativeExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterMultiplicativeExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitMultiplicativeExpr(this);
		}
	}

	public final MultiplicativeExprContext multiplicativeExpr() throws RecognitionException {
		MultiplicativeExprContext _localctx = new MultiplicativeExprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_multiplicativeExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			unaryExpr();
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STAR || _la==SLASH) {
				{
				{
				setState(190);
				_la = _input.LA(1);
				if ( !(_la==STAR || _la==SLASH) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(191);
				unaryExpr();
				}
				}
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryExprContext extends ParserRuleContext {
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(VYPParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(VYPParser.NOT, 0); }
		public PrimaryExprContext primaryExpr() {
			return getRuleContext(PrimaryExprContext.class,0);
		}
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitUnaryExpr(this);
		}
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_unaryExpr);
		int _la;
		try {
			setState(200);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				_la = _input.LA(1);
				if ( !(_la==NOT || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(198);
				unaryExpr();
				}
				break;
			case LPAREN:
			case INT_LITERAL:
			case STRING_LITERAL:
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				primaryExpr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryExprContext extends ParserRuleContext {
		public PrimaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpr; }
	 
		public PrimaryExprContext() { }
		public void copyFrom(PrimaryExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringLiteralContext extends PrimaryExprContext {
		public TerminalNode STRING_LITERAL() { return getToken(VYPParser.STRING_LITERAL, 0); }
		public StringLiteralContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitStringLiteral(this);
		}
	}
	public static class FunctionCallExprContext extends PrimaryExprContext {
		public TerminalNode IDENT() { return getToken(VYPParser.IDENT, 0); }
		public TerminalNode LPAREN() { return getToken(VYPParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(VYPParser.RPAREN, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public FunctionCallExprContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterFunctionCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitFunctionCallExpr(this);
		}
	}
	public static class IntLiteralContext extends PrimaryExprContext {
		public TerminalNode INT_LITERAL() { return getToken(VYPParser.INT_LITERAL, 0); }
		public IntLiteralContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterIntLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitIntLiteral(this);
		}
	}
	public static class VarRefContext extends PrimaryExprContext {
		public TerminalNode IDENT() { return getToken(VYPParser.IDENT, 0); }
		public VarRefContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterVarRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitVarRef(this);
		}
	}
	public static class ParenExprContext extends PrimaryExprContext {
		public TerminalNode LPAREN() { return getToken(VYPParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(VYPParser.RPAREN, 0); }
		public ParenExprContext(PrimaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitParenExpr(this);
		}
	}

	public final PrimaryExprContext primaryExpr() throws RecognitionException {
		PrimaryExprContext _localctx = new PrimaryExprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_primaryExpr);
		int _la;
		try {
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new FunctionCallExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				match(IDENT);
				setState(203);
				match(LPAREN);
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << NOT) | (1L << MINUS) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENT))) != 0)) {
					{
					setState(204);
					argList();
					}
				}

				setState(207);
				match(RPAREN);
				}
				break;
			case 2:
				_localctx = new ParenExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(208);
				match(LPAREN);
				setState(209);
				expr();
				setState(210);
				match(RPAREN);
				}
				break;
			case 3:
				_localctx = new IntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(212);
				match(INT_LITERAL);
				}
				break;
			case 4:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(213);
				match(STRING_LITERAL);
				}
				break;
			case 5:
				_localctx = new VarRefContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(214);
				match(IDENT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(VYPParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(VYPParser.COMMA, i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterArgList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitArgList(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			expr();
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(218);
				match(COMMA);
				setState(219);
				expr();
				}
				}
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(VYPParser.VOID, 0); }
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_type);
		try {
			setState(227);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(225);
				match(VOID);
				}
				break;
			case INT:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				primitiveType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(VYPParser.INT, 0); }
		public TerminalNode STRING() { return getToken(VYPParser.STRING, 0); }
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitPrimitiveType(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%\u00ea\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\7\2\67\n\2\f\2\16\2:\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\5\3C\n\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4K\n\4\f\4\16\4N\13\4\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\5\6V\n\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5"+
		"\7c\n\7\3\b\3\b\7\bg\n\b\f\b\16\bj\13\b\3\b\3\b\3\t\3\t\3\t\3\t\7\tr\n"+
		"\t\f\t\16\tu\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u0085\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\5\r\u008f\n"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\7\20\u009b\n\20\f\20"+
		"\16\20\u009e\13\20\3\21\3\21\3\21\7\21\u00a3\n\21\f\21\16\21\u00a6\13"+
		"\21\3\22\3\22\3\22\7\22\u00ab\n\22\f\22\16\22\u00ae\13\22\3\23\3\23\3"+
		"\23\7\23\u00b3\n\23\f\23\16\23\u00b6\13\23\3\24\3\24\3\24\7\24\u00bb\n"+
		"\24\f\24\16\24\u00be\13\24\3\25\3\25\3\25\7\25\u00c3\n\25\f\25\16\25\u00c6"+
		"\13\25\3\26\3\26\3\26\5\26\u00cb\n\26\3\27\3\27\3\27\5\27\u00d0\n\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00da\n\27\3\30\3\30\3\30"+
		"\7\30\u00df\n\30\f\30\16\30\u00e2\13\30\3\31\3\31\5\31\u00e6\n\31\3\32"+
		"\3\32\3\32\2\2\33\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\2\b\3\2\33\34\3\2\27\32\3\2\25\26\3\2\23\24\4\2\22\22\26\26\4\2\5\5\7"+
		"\7\2\u00ef\28\3\2\2\2\4=\3\2\2\2\6G\3\2\2\2\bO\3\2\2\2\nR\3\2\2\2\fb\3"+
		"\2\2\2\16d\3\2\2\2\20m\3\2\2\2\22x\3\2\2\2\24}\3\2\2\2\26\u0086\3\2\2"+
		"\2\30\u008c\3\2\2\2\32\u0092\3\2\2\2\34\u0095\3\2\2\2\36\u0097\3\2\2\2"+
		" \u009f\3\2\2\2\"\u00a7\3\2\2\2$\u00af\3\2\2\2&\u00b7\3\2\2\2(\u00bf\3"+
		"\2\2\2*\u00ca\3\2\2\2,\u00d9\3\2\2\2.\u00db\3\2\2\2\60\u00e5\3\2\2\2\62"+
		"\u00e7\3\2\2\2\64\67\5\4\3\2\65\67\5\f\7\2\66\64\3\2\2\2\66\65\3\2\2\2"+
		"\67:\3\2\2\28\66\3\2\2\289\3\2\2\29;\3\2\2\2:8\3\2\2\2;<\7\2\2\3<\3\3"+
		"\2\2\2=>\5\60\31\2>?\7!\2\2?B\7\n\2\2@C\5\6\4\2AC\7\b\2\2B@\3\2\2\2BA"+
		"\3\2\2\2BC\3\2\2\2CD\3\2\2\2DE\7\13\2\2EF\5\16\b\2F\5\3\2\2\2GL\5\b\5"+
		"\2HI\7\16\2\2IK\5\b\5\2JH\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\7\3\2"+
		"\2\2NL\3\2\2\2OP\5\62\32\2PQ\7!\2\2Q\t\3\2\2\2RS\7!\2\2SU\7\n\2\2TV\5"+
		".\30\2UT\3\2\2\2UV\3\2\2\2VW\3\2\2\2WX\7\13\2\2XY\7\17\2\2Y\13\3\2\2\2"+
		"Zc\5\16\b\2[c\5\20\t\2\\c\5\22\n\2]c\5\24\13\2^c\5\26\f\2_c\5\30\r\2`"+
		"c\5\32\16\2ac\7\17\2\2bZ\3\2\2\2b[\3\2\2\2b\\\3\2\2\2b]\3\2\2\2b^\3\2"+
		"\2\2b_\3\2\2\2b`\3\2\2\2ba\3\2\2\2c\r\3\2\2\2dh\7\f\2\2eg\5\f\7\2fe\3"+
		"\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2ik\3\2\2\2jh\3\2\2\2kl\7\r\2\2l\17"+
		"\3\2\2\2mn\7%\2\2ns\7!\2\2op\7\16\2\2pr\7!\2\2qo\3\2\2\2ru\3\2\2\2sq\3"+
		"\2\2\2st\3\2\2\2tv\3\2\2\2us\3\2\2\2vw\7\17\2\2w\21\3\2\2\2xy\7!\2\2y"+
		"z\7\21\2\2z{\5\34\17\2{|\7\17\2\2|\23\3\2\2\2}~\7\4\2\2~\177\7\n\2\2\177"+
		"\u0080\5\34\17\2\u0080\u0081\7\13\2\2\u0081\u0084\5\16\b\2\u0082\u0083"+
		"\7\3\2\2\u0083\u0085\5\16\b\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2"+
		"\u0085\25\3\2\2\2\u0086\u0087\7\t\2\2\u0087\u0088\7\n\2\2\u0088\u0089"+
		"\5\34\17\2\u0089\u008a\7\13\2\2\u008a\u008b\5\16\b\2\u008b\27\3\2\2\2"+
		"\u008c\u008e\7\6\2\2\u008d\u008f\5\34\17\2\u008e\u008d\3\2\2\2\u008e\u008f"+
		"\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\7\17\2\2\u0091\31\3\2\2\2\u0092"+
		"\u0093\5\34\17\2\u0093\u0094\7\17\2\2\u0094\33\3\2\2\2\u0095\u0096\5\36"+
		"\20\2\u0096\35\3\2\2\2\u0097\u009c\5 \21\2\u0098\u0099\7\36\2\2\u0099"+
		"\u009b\5 \21\2\u009a\u0098\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2"+
		"\2\2\u009c\u009d\3\2\2\2\u009d\37\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a4"+
		"\5\"\22\2\u00a0\u00a1\7\35\2\2\u00a1\u00a3\5\"\22\2\u00a2\u00a0\3\2\2"+
		"\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5!"+
		"\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00ac\5$\23\2\u00a8\u00a9\t\2\2\2\u00a9"+
		"\u00ab\5$\23\2\u00aa\u00a8\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2"+
		"\2\2\u00ac\u00ad\3\2\2\2\u00ad#\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b4"+
		"\5&\24\2\u00b0\u00b1\t\3\2\2\u00b1\u00b3\5&\24\2\u00b2\u00b0\3\2\2\2\u00b3"+
		"\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5%\3\2\2\2"+
		"\u00b6\u00b4\3\2\2\2\u00b7\u00bc\5(\25\2\u00b8\u00b9\t\4\2\2\u00b9\u00bb"+
		"\5(\25\2\u00ba\u00b8\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc"+
		"\u00bd\3\2\2\2\u00bd\'\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c4\5*\26\2"+
		"\u00c0\u00c1\t\5\2\2\u00c1\u00c3\5*\26\2\u00c2\u00c0\3\2\2\2\u00c3\u00c6"+
		"\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5)\3\2\2\2\u00c6"+
		"\u00c4\3\2\2\2\u00c7\u00c8\t\6\2\2\u00c8\u00cb\5*\26\2\u00c9\u00cb\5,"+
		"\27\2\u00ca\u00c7\3\2\2\2\u00ca\u00c9\3\2\2\2\u00cb+\3\2\2\2\u00cc\u00cd"+
		"\7!\2\2\u00cd\u00cf\7\n\2\2\u00ce\u00d0\5.\30\2\u00cf\u00ce\3\2\2\2\u00cf"+
		"\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00da\7\13\2\2\u00d2\u00d3\7"+
		"\n\2\2\u00d3\u00d4\5\34\17\2\u00d4\u00d5\7\13\2\2\u00d5\u00da\3\2\2\2"+
		"\u00d6\u00da\7\37\2\2\u00d7\u00da\7 \2\2\u00d8\u00da\7!\2\2\u00d9\u00cc"+
		"\3\2\2\2\u00d9\u00d2\3\2\2\2\u00d9\u00d6\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9"+
		"\u00d8\3\2\2\2\u00da-\3\2\2\2\u00db\u00e0\5\34\17\2\u00dc\u00dd\7\16\2"+
		"\2\u00dd\u00df\5\34\17\2\u00de\u00dc\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0"+
		"\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1/\3\2\2\2\u00e2\u00e0\3\2\2\2"+
		"\u00e3\u00e6\7\b\2\2\u00e4\u00e6\5\62\32\2\u00e5\u00e3\3\2\2\2\u00e5\u00e4"+
		"\3\2\2\2\u00e6\61\3\2\2\2\u00e7\u00e8\t\7\2\2\u00e8\63\3\2\2\2\27\668"+
		"BLUbhs\u0084\u008e\u009c\u00a4\u00ac\u00b4\u00bc\u00c4\u00ca\u00cf\u00d9"+
		"\u00e0\u00e5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}