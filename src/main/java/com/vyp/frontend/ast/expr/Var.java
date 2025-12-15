package com.vyp.frontend.ast.expr;

import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ASTVisitor;

public class Var extends Expression {
    
    private String name;//the name of the variable

     /** Constructor for Var */
    public Var(String name, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.name = name;
    }

    /** Getter fpr tje variable name */
    public String getName() {
        return name;
    }

    /** Method accept redefined */
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {    
        return visitor.visit(this);
    }   
}