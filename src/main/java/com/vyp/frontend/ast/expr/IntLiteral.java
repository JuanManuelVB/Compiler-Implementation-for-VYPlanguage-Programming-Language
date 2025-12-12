package com.vyp.frontend.ast.expr;

import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ASTVisitor;

public class IntLiteral extends Expression {

    private int value;

    public IntLiteral(int value, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {    
        return visitor.visit(this);
    }   

}
