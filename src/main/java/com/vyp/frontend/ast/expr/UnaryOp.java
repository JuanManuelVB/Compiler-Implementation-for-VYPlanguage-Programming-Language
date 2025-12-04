package com.vyp.frontend.ast.expr;

public class UnaryOp extends Expr {
    private final String op;
    private final Expr expr;

    public UnaryOp(String op, Expr expr) { this.op = op; this.expr = expr; }
    public String getOp() { return op; }
    public Expr getExpr() { return expr; }
}
