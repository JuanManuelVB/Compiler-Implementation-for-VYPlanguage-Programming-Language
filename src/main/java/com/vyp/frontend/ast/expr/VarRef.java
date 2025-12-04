package com.vyp.frontend.ast.expr;

public class VarRef extends Expr {
    private final String name;

    public VarRef(String name) { this.name = name; }
    public String getName() { return name; }
}
