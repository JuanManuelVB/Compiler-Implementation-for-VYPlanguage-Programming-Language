package com.vyp;

import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ast.expr.BinaryOp;
import com.vyp.frontend.ast.expr.Expression;
import com.vyp.frontend.ast.expr.IntLiteral;

public class Main {
    
public static void main(String[] args) {
    Expression e = new BinaryOp(
        new IntLiteral(1, new SourceLocation(1,1)),
        new IntLiteral(2, new SourceLocation(1,3)),
        BinaryOp.BinaryOperator.ADD,
        new SourceLocation(1,2)
    );

    System.out.println("Salida: " + e); // debe imprimir algo coherente

    /*Test que compruebe que funciona ast builder y symbol table */


}

}
