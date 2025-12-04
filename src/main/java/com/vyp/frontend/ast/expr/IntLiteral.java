package com.vyp.frontend.ast.expr;

public class IntLiteral extends Expr {
    private final int value;

    public IntLiteral(int value) { this.value = value; }
    public int getValue() { return value; }
}
