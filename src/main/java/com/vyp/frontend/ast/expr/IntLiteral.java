package com.vyp.frontend.ast.expr;

import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ASTVisitor;

public class IntLiteral extends Expression {

    private int value; //the integer value of the literal

    /** Constructor for IntLiteral */
    public IntLiteral(int value, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.value = value;
    }

    /** Getter for the integer value */
    public int getValue() {
        return value;
    }

    /** Method accept redefined */
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {    
        return visitor.visit(this);
    }   

}
