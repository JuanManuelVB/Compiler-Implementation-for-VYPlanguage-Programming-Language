grammar VYP;


// The starting rule of the grammar
program: ( functionDecl  | statement)* EOF;

// functionDecl
functionDecl: type IDENT LPAREN (paramList | VOID)? RPAREN block;
paramList: param (COMMA param)*;
param: primitiveType IDENT;

/* Function call as a standalone statement: fun_id ( ( expr ( , expr )* )? ) ; */
functionCallStmt: IDENT LPAREN argList? RPAREN SEMI;

//BLOCKS & STATEMENTS
statement:
	block
	| localVarDecl // definition of local variables (no initializer)
	| assignStmt
	| ifStmt
	| whileStmt
	| returnStmt
	| exprStmt
	| SEMI ; // empty statement

block: LBRACE statement* RBRACE;

/* Local variable definitions */
localVarDecl:DATA_TYPE IDENT (COMMA IDENT)* SEMI;

assignStmt: IDENT ASSIGN expr SEMI;

ifStmt: IF LPAREN expr RPAREN block (ELSE block)?;

whileStmt: WHILE LPAREN expr RPAREN block;

returnStmt: RETURN expr? SEMI;

exprStmt: expr SEMI;

// EXPRESSIONS (precedence from highest to lowest)
expr
	: logicalOrExpr
	;

logicalOrExpr
	: logicalAndExpr ( OR logicalAndExpr )*
	;

logicalAndExpr
	: equalityExpr ( AND equalityExpr )*
	;

equalityExpr
	: relationalExpr ( (EQ | NEQ) relationalExpr )*
	;

relationalExpr
	: additiveExpr ( (LT | LTE | GT | GTE) additiveExpr )*
	;

additiveExpr
	: multiplicativeExpr ( (PLUS | MINUS) multiplicativeExpr )*
	;

multiplicativeExpr
	: unaryExpr ( (STAR | SLASH) unaryExpr )*
	;

unaryExpr
	: (MINUS | NOT) unaryExpr
	| primaryExpr
	;

primaryExpr
	: IDENT LPAREN argList? RPAREN    # functionCallExpr
	| LPAREN expr RPAREN             # parenExpr
	| INT_LITERAL                    # intLiteral
	| STRING_LITERAL                 # stringLiteral
	| IDENT                          # varRef
	;

argList: expr (COMMA expr)*;



//TYPES
// Types: primitive types (int, string) and void
type: VOID | primitiveType;
primitiveType: INT | STRING;

//LEXER (tokens explícitos)


/* Keywords (declara antes de IDENT para resolución) */
ELSE: 'else';
IF: 'if';
INT: 'int';
RETURN: 'return';
STRING: 'string';
VOID: 'void';
WHILE: 'while';



/* Symbols */
LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
COMMA: ',';
SEMI: ';';
COLON: ':';
ASSIGN: '=';

/* Operators (multi-char operators before single-char where relevant) */
NOT: '!';
STAR: '*';
SLASH: '/';
PLUS: '+';
MINUS: '-';
LTE: '<=';
GTE: '>=';
LT: '<';
GT: '>';
EQ: '==';
NEQ: '!=';
AND: '&&';
OR: '||';



/* Literals and identifiers */
INT_LITERAL: [0-9]+;


STRING_LITERAL
    : '"' ( '\\' ( 'n' | 't' | '\\' | '"' | 'x' [0-9A-Fa-f]{6} )
    | ~[\u0000-\u001F\u0022\\])* '"';

/* Identifiers (declared after keywords so keywords match as tokens) */
IDENT: [a-zA-Z_] [a-zA-Z0-9_]*;

/* Whitespace and comments */
WS: [ \t\r\n]+ -> skip;
LINE_COMMENT: '//' ~[\r\n]* -> skip;
BLOCK_COMMENT: '/*' .*? '*/' -> skip;

/* End of grammar */