package com.vyp.frontend.ast.expr;

import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ASTVisitor;

public class Var extends Expression {
    
    private String name;

    public Var(String name, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {    
        return visitor.visit(this);
    }   
}