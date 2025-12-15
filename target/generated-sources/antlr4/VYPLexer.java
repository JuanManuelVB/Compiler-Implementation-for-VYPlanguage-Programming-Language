// Generated from VYP.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class VYPLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ELSE=1, IF=2, INT=3, RETURN=4, STRING=5, VOID=6, WHILE=7, LPAREN=8, RPAREN=9, 
		LBRACE=10, RBRACE=11, COMMA=12, SEMI=13, COLON=14, ASSIGN=15, NOT=16, 
		STAR=17, SLASH=18, PLUS=19, MINUS=20, LTE=21, GTE=22, LT=23, GT=24, EQ=25, 
		NEQ=26, AND=27, OR=28, INT_LITERAL=29, STRING_LITERAL=30, IDENT=31, WS=32, 
		LINE_COMMENT=33, BLOCK_COMMENT=34;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ELSE", "IF", "INT", "RETURN", "STRING", "VOID", "WHILE", "LPAREN", "RPAREN", 
			"LBRACE", "RBRACE", "COMMA", "SEMI", "COLON", "ASSIGN", "NOT", "STAR", 
			"SLASH", "PLUS", "MINUS", "LTE", "GTE", "LT", "GT", "EQ", "NEQ", "AND", 
			"OR", "INT_LITERAL", "STRING_LITERAL", "IDENT", "WS", "LINE_COMMENT", 
			"BLOCK_COMMENT"
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


	public VYPLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "VYP.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 29:
			STRING_LITERAL_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void STRING_LITERAL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			6
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u00d8\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3"+
		"\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3"+
		"\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\36\6\36\u009e\n\36"+
		"\r\36\16\36\u009f\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u00a8\n\37\3\37\7"+
		"\37\u00ab\n\37\f\37\16\37\u00ae\13\37\3\37\3\37\3 \3 \7 \u00b4\n \f \16"+
		" \u00b7\13 \3!\6!\u00ba\n!\r!\16!\u00bb\3!\3!\3\"\3\"\3\"\3\"\7\"\u00c4"+
		"\n\"\f\"\16\"\u00c7\13\"\3\"\3\"\3#\3#\3#\3#\7#\u00cf\n#\f#\16#\u00d2"+
		"\13#\3#\3#\3#\3#\3#\3\u00d0\2$\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$\3\2\n\3\2\62;\6\2$$^^ppvv\5\2"+
		"\62;CHch\5\2\2!$$^^\5\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\4\2\f"+
		"\f\17\17\2\u00df\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\3G\3\2\2\2\5L\3\2\2\2\7O\3\2\2\2\tS\3\2\2\2\13Z\3\2\2\2\ra\3"+
		"\2\2\2\17f\3\2\2\2\21l\3\2\2\2\23n\3\2\2\2\25p\3\2\2\2\27r\3\2\2\2\31"+
		"t\3\2\2\2\33v\3\2\2\2\35x\3\2\2\2\37z\3\2\2\2!|\3\2\2\2#~\3\2\2\2%\u0080"+
		"\3\2\2\2\'\u0082\3\2\2\2)\u0084\3\2\2\2+\u0086\3\2\2\2-\u0089\3\2\2\2"+
		"/\u008c\3\2\2\2\61\u008e\3\2\2\2\63\u0090\3\2\2\2\65\u0093\3\2\2\2\67"+
		"\u0096\3\2\2\29\u0099\3\2\2\2;\u009d\3\2\2\2=\u00a1\3\2\2\2?\u00b1\3\2"+
		"\2\2A\u00b9\3\2\2\2C\u00bf\3\2\2\2E\u00ca\3\2\2\2GH\7g\2\2HI\7n\2\2IJ"+
		"\7u\2\2JK\7g\2\2K\4\3\2\2\2LM\7k\2\2MN\7h\2\2N\6\3\2\2\2OP\7k\2\2PQ\7"+
		"p\2\2QR\7v\2\2R\b\3\2\2\2ST\7t\2\2TU\7g\2\2UV\7v\2\2VW\7w\2\2WX\7t\2\2"+
		"XY\7p\2\2Y\n\3\2\2\2Z[\7u\2\2[\\\7v\2\2\\]\7t\2\2]^\7k\2\2^_\7p\2\2_`"+
		"\7i\2\2`\f\3\2\2\2ab\7x\2\2bc\7q\2\2cd\7k\2\2de\7f\2\2e\16\3\2\2\2fg\7"+
		"y\2\2gh\7j\2\2hi\7k\2\2ij\7n\2\2jk\7g\2\2k\20\3\2\2\2lm\7*\2\2m\22\3\2"+
		"\2\2no\7+\2\2o\24\3\2\2\2pq\7}\2\2q\26\3\2\2\2rs\7\177\2\2s\30\3\2\2\2"+
		"tu\7.\2\2u\32\3\2\2\2vw\7=\2\2w\34\3\2\2\2xy\7<\2\2y\36\3\2\2\2z{\7?\2"+
		"\2{ \3\2\2\2|}\7#\2\2}\"\3\2\2\2~\177\7,\2\2\177$\3\2\2\2\u0080\u0081"+
		"\7\61\2\2\u0081&\3\2\2\2\u0082\u0083\7-\2\2\u0083(\3\2\2\2\u0084\u0085"+
		"\7/\2\2\u0085*\3\2\2\2\u0086\u0087\7>\2\2\u0087\u0088\7?\2\2\u0088,\3"+
		"\2\2\2\u0089\u008a\7@\2\2\u008a\u008b\7?\2\2\u008b.\3\2\2\2\u008c\u008d"+
		"\7>\2\2\u008d\60\3\2\2\2\u008e\u008f\7@\2\2\u008f\62\3\2\2\2\u0090\u0091"+
		"\7?\2\2\u0091\u0092\7?\2\2\u0092\64\3\2\2\2\u0093\u0094\7#\2\2\u0094\u0095"+
		"\7?\2\2\u0095\66\3\2\2\2\u0096\u0097\7(\2\2\u0097\u0098\7(\2\2\u00988"+
		"\3\2\2\2\u0099\u009a\7~\2\2\u009a\u009b\7~\2\2\u009b:\3\2\2\2\u009c\u009e"+
		"\t\2\2\2\u009d\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u009d\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0<\3\2\2\2\u00a1\u00ac\7$\2\2\u00a2\u00a7\7^\2\2\u00a3"+
		"\u00a8\t\3\2\2\u00a4\u00a5\7z\2\2\u00a5\u00a6\t\4\2\2\u00a6\u00a8\b\37"+
		"\2\2\u00a7\u00a3\3\2\2\2\u00a7\u00a4\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9"+
		"\u00ab\n\5\2\2\u00aa\u00a2\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2"+
		"\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae"+
		"\u00ac\3\2\2\2\u00af\u00b0\7$\2\2\u00b0>\3\2\2\2\u00b1\u00b5\t\6\2\2\u00b2"+
		"\u00b4\t\7\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2"+
		"\2\2\u00b5\u00b6\3\2\2\2\u00b6@\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00ba"+
		"\t\b\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb"+
		"\u00bc\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\b!\3\2\u00beB\3\2\2\2\u00bf"+
		"\u00c0\7\61\2\2\u00c0\u00c1\7\61\2\2\u00c1\u00c5\3\2\2\2\u00c2\u00c4\n"+
		"\t\2\2\u00c3\u00c2\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5"+
		"\u00c6\3\2\2\2\u00c6\u00c8\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00c9\b\""+
		"\3\2\u00c9D\3\2\2\2\u00ca\u00cb\7\61\2\2\u00cb\u00cc\7,\2\2\u00cc\u00d0"+
		"\3\2\2\2\u00cd\u00cf\13\2\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00d2\3\2\2\2"+
		"\u00d0\u00d1\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d3\3\2\2\2\u00d2\u00d0"+
		"\3\2\2\2\u00d3\u00d4\7,\2\2\u00d4\u00d5\7\61\2\2\u00d5\u00d6\3\2\2\2\u00d6"+
		"\u00d7\b#\3\2\u00d7F\3\2\2\2\13\2\u009f\u00a7\u00aa\u00ac\u00b5\u00bb"+
		"\u00c5\u00d0\4\3\37\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}