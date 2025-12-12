package com.vyp.frontend.ast;

import com.vyp.frontend.ASTVisitor;
import com.vyp.semantic.type.*;

public class Parameter extends ASTNode {

    private String name;
    private Type type;


    public Parameter(String name, Type type, SourceLocation loc) {
        super(loc);
        this.name = name;
        this.type = type;
    }

    public String getName() { return name; }
    public Type getType() { return type; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
