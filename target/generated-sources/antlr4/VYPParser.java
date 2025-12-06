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
		DATA_TYPE=1, ELSE=2, IF=3, INT=4, RETURN=5, STRING=6, VOID=7, WHILE=8, 
		LPAREN=9, RPAREN=10, LBRACE=11, RBRACE=12, COMMA=13, SEMI=14, COLON=15, 
		ASSIGN=16, NOT=17, STAR=18, SLASH=19, PLUS=20, MINUS=21, LTE=22, GTE=23, 
		LT=24, GT=25, EQ=26, NEQ=27, AND=28, OR=29, INT_LITERAL=30, STRING_LITERAL=31, 
		IDENT=32, WS=33, LINE_COMMENT=34, BLOCK_COMMENT=35;
	public static final int
		RULE_program = 0, RULE_functionDecl = 1, RULE_paramList = 2, RULE_param = 3, 
		RULE_functionCall = 4, RULE_statement = 5, RULE_block = 6, RULE_localVarDecl = 7, 
		RULE_assignStmt = 8, RULE_ifStmt = 9, RULE_whileStmt = 10, RULE_returnStmt = 11, 
		RULE_exprStmt = 12, RULE_expr = 13, RULE_unaryExpr = 14, RULE_primaryExpr = 15, 
		RULE_argList = 16, RULE_type = 17, RULE_operators = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "functionDecl", "paramList", "param", "functionCall", "statement", 
			"block", "localVarDecl", "assignStmt", "ifStmt", "whileStmt", "returnStmt", 
			"exprStmt", "expr", "unaryExpr", "primaryExpr", "argList", "type", "operators"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'else'", "'if'", "'int'", "'return'", "'string'", "'void'", 
			"'while'", "'('", "')'", "'{'", "'}'", "','", "';'", "':'", "'='", "'!'", 
			"'*'", "'/'", "'+'", "'-'", "'<='", "'>='", "'<'", "'>'", "'=='", "'!='", 
			"'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DATA_TYPE", "ELSE", "IF", "INT", "RETURN", "STRING", "VOID", "WHILE", 
			"LPAREN", "RPAREN", "LBRACE", "RBRACE", "COMMA", "SEMI", "COLON", "ASSIGN", 
			"NOT", "STAR", "SLASH", "PLUS", "MINUS", "LTE", "GTE", "LT", "GT", "EQ", 
			"NEQ", "AND", "OR", "INT_LITERAL", "STRING_LITERAL", "IDENT", "WS", "LINE_COMMENT", 
			"BLOCK_COMMENT"
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
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DATA_TYPE) | (1L << IF) | (1L << RETURN) | (1L << VOID) | (1L << WHILE) | (1L << LBRACE) | (1L << RBRACE) | (1L << SEMI) | (1L << STAR) | (1L << SLASH) | (1L << PLUS) | (1L << MINUS) | (1L << LTE) | (1L << GTE) | (1L << LT) | (1L << GT) | (1L << EQ) | (1L << NEQ) | (1L << AND) | (1L << OR) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENT))) != 0)) {
				{
				setState(40);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(38);
					functionDecl();
					}
					break;
				case 2:
					{
					setState(39);
					statement();
					}
					break;
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(45);
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
			setState(47);
			type();
			setState(48);
			match(IDENT);
			setState(49);
			match(LPAREN);
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DATA_TYPE:
				{
				setState(50);
				paramList();
				}
				break;
			case VOID:
				{
				setState(51);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(54);
			match(RPAREN);
			setState(55);
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
			setState(57);
			param();
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(58);
				match(COMMA);
				setState(59);
				param();
				}
				}
				setState(64);
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
		public TerminalNode DATA_TYPE() { return getToken(VYPParser.DATA_TYPE, 0); }
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
			setState(65);
			match(DATA_TYPE);
			setState(66);
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

	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(VYPParser.IDENT, 0); }
		public TerminalNode LPAREN() { return getToken(VYPParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(VYPParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(VYPParser.SEMI, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(IDENT);
			setState(69);
			match(LPAREN);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DATA_TYPE) | (1L << LBRACE) | (1L << RBRACE) | (1L << STAR) | (1L << SLASH) | (1L << PLUS) | (1L << MINUS) | (1L << LTE) | (1L << GTE) | (1L << LT) | (1L << GT) | (1L << EQ) | (1L << NEQ) | (1L << AND) | (1L << OR) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENT))) != 0)) {
				{
				setState(70);
				argList();
				}
			}

			setState(73);
			match(RPAREN);
			setState(74);
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
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
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
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				localVarDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				assignStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				ifStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(80);
				whileStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(81);
				returnStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(82);
				functionCall();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(83);
				exprStmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(84);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(LBRACE);
			setState(91);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(88);
					statement();
					}
					} 
				}
				setState(93);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(94);
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
			setState(96);
			match(DATA_TYPE);
			setState(97);
			match(IDENT);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(98);
				match(COMMA);
				setState(99);
				match(IDENT);
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(105);
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
			setState(107);
			match(IDENT);
			setState(108);
			match(ASSIGN);
			setState(109);
			expr();
			setState(110);
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
			setState(112);
			match(IF);
			setState(113);
			match(LPAREN);
			setState(114);
			expr();
			setState(115);
			match(RPAREN);
			setState(116);
			block();
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(117);
				match(ELSE);
				setState(118);
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
			setState(121);
			match(WHILE);
			setState(122);
			match(LPAREN);
			setState(123);
			expr();
			setState(124);
			match(RPAREN);
			setState(125);
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
			setState(127);
			match(RETURN);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DATA_TYPE) | (1L << LBRACE) | (1L << RBRACE) | (1L << STAR) | (1L << SLASH) | (1L << PLUS) | (1L << MINUS) | (1L << LTE) | (1L << GTE) | (1L << LT) | (1L << GT) | (1L << EQ) | (1L << NEQ) | (1L << AND) | (1L << OR) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << IDENT))) != 0)) {
				{
				setState(128);
				expr();
				}
			}

			setState(131);
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
			setState(133);
			expr();
			setState(134);
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
		public TerminalNode STRING_LITERAL() { return getToken(VYPParser.STRING_LITERAL, 0); }
		public TerminalNode INT_LITERAL() { return getToken(VYPParser.INT_LITERAL, 0); }
		public LocalVarDeclContext localVarDecl() {
			return getRuleContext(LocalVarDeclContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(VYPParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(VYPParser.RBRACE, 0); }
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public OperatorsContext operators() {
			return getRuleContext(OperatorsContext.class,0);
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
			setState(143);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				match(STRING_LITERAL);
				}
				break;
			case INT_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				match(INT_LITERAL);
				}
				break;
			case DATA_TYPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(138);
				localVarDecl();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 4);
				{
				setState(139);
				match(LBRACE);
				}
				break;
			case RBRACE:
				enterOuterAlt(_localctx, 5);
				{
				setState(140);
				match(RBRACE);
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 6);
				{
				setState(141);
				functionCall();
				}
				break;
			case STAR:
			case SLASH:
			case PLUS:
			case MINUS:
			case LTE:
			case GTE:
			case LT:
			case GT:
			case EQ:
			case NEQ:
			case AND:
			case OR:
				enterOuterAlt(_localctx, 7);
				{
				setState(142);
				operators();
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
		enterRule(_localctx, 28, RULE_unaryExpr);
		int _la;
		try {
			setState(148);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				_la = _input.LA(1);
				if ( !(_la==NOT || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(146);
				unaryExpr();
				}
				break;
			case LPAREN:
			case INT_LITERAL:
			case STRING_LITERAL:
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
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
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
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
		enterRule(_localctx, 30, RULE_primaryExpr);
		try {
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new FunctionCallExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				functionCall();
				}
				break;
			case 2:
				_localctx = new ParenExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				match(LPAREN);
				setState(152);
				expr();
				setState(153);
				match(RPAREN);
				}
				break;
			case 3:
				_localctx = new IntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(155);
				match(INT_LITERAL);
				}
				break;
			case 4:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(156);
				match(STRING_LITERAL);
				}
				break;
			case 5:
				_localctx = new VarRefContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(157);
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
		enterRule(_localctx, 32, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			expr();
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(161);
				match(COMMA);
				setState(162);
				expr();
				}
				}
				setState(167);
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
		public TerminalNode DATA_TYPE() { return getToken(VYPParser.DATA_TYPE, 0); }
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
		enterRule(_localctx, 34, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			_la = _input.LA(1);
			if ( !(_la==DATA_TYPE || _la==VOID) ) {
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

	public static class OperatorsContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(VYPParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(VYPParser.SLASH, 0); }
		public TerminalNode PLUS() { return getToken(VYPParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(VYPParser.MINUS, 0); }
		public TerminalNode LTE() { return getToken(VYPParser.LTE, 0); }
		public TerminalNode GTE() { return getToken(VYPParser.GTE, 0); }
		public TerminalNode LT() { return getToken(VYPParser.LT, 0); }
		public TerminalNode GT() { return getToken(VYPParser.GT, 0); }
		public TerminalNode EQ() { return getToken(VYPParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(VYPParser.NEQ, 0); }
		public TerminalNode AND() { return getToken(VYPParser.AND, 0); }
		public TerminalNode OR() { return getToken(VYPParser.OR, 0); }
		public OperatorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).enterOperators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VYPListener ) ((VYPListener)listener).exitOperators(this);
		}
	}

	public final OperatorsContext operators() throws RecognitionException {
		OperatorsContext _localctx = new OperatorsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_operators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << SLASH) | (1L << PLUS) | (1L << MINUS) | (1L << LTE) | (1L << GTE) | (1L << LT) | (1L << GT) | (1L << EQ) | (1L << NEQ) | (1L << AND) | (1L << OR))) != 0)) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%\u00af\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\7\2+\n\2\f\2\16\2.\13\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\3\5\3\67\n\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4?\n\4\f\4\16\4B\13\4"+
		"\3\5\3\5\3\5\3\6\3\6\3\6\5\6J\n\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\5\7X\n\7\3\b\3\b\7\b\\\n\b\f\b\16\b_\13\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\7\tg\n\t\f\t\16\tj\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13z\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\5"+
		"\r\u0084\n\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\5\17\u0092\n\17\3\20\3\20\3\20\5\20\u0097\n\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\5\21\u00a1\n\21\3\22\3\22\3\22\7\22\u00a6\n\22\f\22"+
		"\16\22\u00a9\13\22\3\23\3\23\3\24\3\24\3\24\2\2\25\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&\2\5\4\2\23\23\27\27\4\2\3\3\t\t\3\2\24\37\2\u00b8"+
		"\2,\3\2\2\2\4\61\3\2\2\2\6;\3\2\2\2\bC\3\2\2\2\nF\3\2\2\2\fW\3\2\2\2\16"+
		"Y\3\2\2\2\20b\3\2\2\2\22m\3\2\2\2\24r\3\2\2\2\26{\3\2\2\2\30\u0081\3\2"+
		"\2\2\32\u0087\3\2\2\2\34\u0091\3\2\2\2\36\u0096\3\2\2\2 \u00a0\3\2\2\2"+
		"\"\u00a2\3\2\2\2$\u00aa\3\2\2\2&\u00ac\3\2\2\2(+\5\4\3\2)+\5\f\7\2*(\3"+
		"\2\2\2*)\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-/\3\2\2\2.,\3\2\2\2/\60"+
		"\7\2\2\3\60\3\3\2\2\2\61\62\5$\23\2\62\63\7\"\2\2\63\66\7\13\2\2\64\67"+
		"\5\6\4\2\65\67\7\t\2\2\66\64\3\2\2\2\66\65\3\2\2\2\678\3\2\2\289\7\f\2"+
		"\29:\5\16\b\2:\5\3\2\2\2;@\5\b\5\2<=\7\17\2\2=?\5\b\5\2><\3\2\2\2?B\3"+
		"\2\2\2@>\3\2\2\2@A\3\2\2\2A\7\3\2\2\2B@\3\2\2\2CD\7\3\2\2DE\7\"\2\2E\t"+
		"\3\2\2\2FG\7\"\2\2GI\7\13\2\2HJ\5\"\22\2IH\3\2\2\2IJ\3\2\2\2JK\3\2\2\2"+
		"KL\7\f\2\2LM\7\20\2\2M\13\3\2\2\2NX\5\16\b\2OX\5\20\t\2PX\5\22\n\2QX\5"+
		"\24\13\2RX\5\26\f\2SX\5\30\r\2TX\5\n\6\2UX\5\32\16\2VX\7\20\2\2WN\3\2"+
		"\2\2WO\3\2\2\2WP\3\2\2\2WQ\3\2\2\2WR\3\2\2\2WS\3\2\2\2WT\3\2\2\2WU\3\2"+
		"\2\2WV\3\2\2\2X\r\3\2\2\2Y]\7\r\2\2Z\\\5\f\7\2[Z\3\2\2\2\\_\3\2\2\2]["+
		"\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2`a\7\16\2\2a\17\3\2\2\2bc\7\3\2"+
		"\2ch\7\"\2\2de\7\17\2\2eg\7\"\2\2fd\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2"+
		"\2\2ik\3\2\2\2jh\3\2\2\2kl\7\20\2\2l\21\3\2\2\2mn\7\"\2\2no\7\22\2\2o"+
		"p\5\34\17\2pq\7\20\2\2q\23\3\2\2\2rs\7\5\2\2st\7\13\2\2tu\5\34\17\2uv"+
		"\7\f\2\2vy\5\16\b\2wx\7\4\2\2xz\5\16\b\2yw\3\2\2\2yz\3\2\2\2z\25\3\2\2"+
		"\2{|\7\n\2\2|}\7\13\2\2}~\5\34\17\2~\177\7\f\2\2\177\u0080\5\16\b\2\u0080"+
		"\27\3\2\2\2\u0081\u0083\7\7\2\2\u0082\u0084\5\34\17\2\u0083\u0082\3\2"+
		"\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\7\20\2\2\u0086"+
		"\31\3\2\2\2\u0087\u0088\5\34\17\2\u0088\u0089\7\20\2\2\u0089\33\3\2\2"+
		"\2\u008a\u0092\7!\2\2\u008b\u0092\7 \2\2\u008c\u0092\5\20\t\2\u008d\u0092"+
		"\7\r\2\2\u008e\u0092\7\16\2\2\u008f\u0092\5\n\6\2\u0090\u0092\5&\24\2"+
		"\u0091\u008a\3\2\2\2\u0091\u008b\3\2\2\2\u0091\u008c\3\2\2\2\u0091\u008d"+
		"\3\2\2\2\u0091\u008e\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0090\3\2\2\2\u0092"+
		"\35\3\2\2\2\u0093\u0094\t\2\2\2\u0094\u0097\5\36\20\2\u0095\u0097\5 \21"+
		"\2\u0096\u0093\3\2\2\2\u0096\u0095\3\2\2\2\u0097\37\3\2\2\2\u0098\u00a1"+
		"\5\n\6\2\u0099\u009a\7\13\2\2\u009a\u009b\5\34\17\2\u009b\u009c\7\f\2"+
		"\2\u009c\u00a1\3\2\2\2\u009d\u00a1\7 \2\2\u009e\u00a1\7!\2\2\u009f\u00a1"+
		"\7\"\2\2\u00a0\u0098\3\2\2\2\u00a0\u0099\3\2\2\2\u00a0\u009d\3\2\2\2\u00a0"+
		"\u009e\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1!\3\2\2\2\u00a2\u00a7\5\34\17"+
		"\2\u00a3\u00a4\7\17\2\2\u00a4\u00a6\5\34\17\2\u00a5\u00a3\3\2\2\2\u00a6"+
		"\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8#\3\2\2\2"+
		"\u00a9\u00a7\3\2\2\2\u00aa\u00ab\t\3\2\2\u00ab%\3\2\2\2\u00ac\u00ad\t"+
		"\4\2\2\u00ad\'\3\2\2\2\20*,\66@IW]hy\u0083\u0091\u0096\u00a0\u00a7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}