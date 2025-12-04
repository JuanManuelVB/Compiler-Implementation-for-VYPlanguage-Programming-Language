package com.vyp.frontend.ast.expr;

import java.util.List;

public class FunctionCallExpr extends Expr {
    private final String name;
    private final List<Expr> args;

    public FunctionCallExpr(String name, List<Expr> args) { this.name = name; this.args = args; }
    public String getName() { return name; }
    public List<Expr> getArgs() { return args; }
}
