package com.vyp.frontend.ast;

public class Parameter implements ASTNode {
    private final String name;
    private final String type; // simple representation for now

    public Parameter(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() { return name; }
    public String getType() { return type; }
}
