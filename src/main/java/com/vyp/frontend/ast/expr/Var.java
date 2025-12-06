package com.vyp.frontend.ast.expr;
import com.vyp.frontend.ast.SourceLocation;

public class Var extends Expr {
    
    private String name;

    public Var(String name, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}