grammar VYP;

program: statement* EOF;

statement: 'print' expr ';' ;

expr: INT ;

INT: [0-9]+ ;
WS: [ \t\r\n]+ -> skip ;
