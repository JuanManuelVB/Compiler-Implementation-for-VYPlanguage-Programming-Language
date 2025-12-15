package com.vyp.frontend.ast;

import com.vyp.frontend.ASTVisitor;
import com.vyp.semantic.type.*;

// Representation of a function parameter/s in my language
public class Parameter extends ASTNode {

    private String name;//the name of the parameter
    private Type type;//the type of the parameter

     /** Constructor for Parameter */
    public Parameter(String name, Type type, SourceLocation loc) {
        super(loc);
        this.name = name;
        this.type = type;
    }

    // Getters for name and type
    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    //** Method accept redefined */
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
