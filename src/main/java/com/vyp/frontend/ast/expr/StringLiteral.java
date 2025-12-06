package com.vyp.frontend.ast.expr;

import com.vyp.frontend.ast.SourceLocation;

public class StringLiteral extends Expr {
     private String value;

    public StringLiteral(String value, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.value = value;
    }

    public String getValue() {
        return value;
    }   

}
