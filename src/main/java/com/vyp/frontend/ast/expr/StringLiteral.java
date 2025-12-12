package com.vyp.frontend.ast.expr;

import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ASTVisitor;

public class StringLiteral extends Expression {
    
     private String value;

    public StringLiteral(String value, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.value = value;
    }

    public String getValue() {
        return value;
    }   

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {    
        return visitor.visit(this);
    }   

}
