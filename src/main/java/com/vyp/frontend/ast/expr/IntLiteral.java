package com.vyp.frontend.ast.expr;

import com.vyp.frontend.ast.SourceLocation;

public class IntLiteral extends Expr {
    // Skeleton: int literal removed
    private int value;

    public IntLiteral(int value, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
