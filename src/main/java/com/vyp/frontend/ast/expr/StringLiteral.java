package com.vyp.frontend.ast.expr;

import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ASTVisitor;

public class StringLiteral extends Expression {
    
    private String value; //the string value of the literal

    /** Constructor for StringLiteral */
    public StringLiteral(String value, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.value = value;
    }

    /** Getter for the string value */
    public String getValue() {
        return value;
    }   

    /** Method accept redefined */
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {    
        return visitor.visit(this);
    }   

}
