package com.vyp.frontend.ast.expr;

public class BinaryOp extends Expr {
    private final String op;
    private final Expr left, right;

    public BinaryOp(String op, Expr left, Expr right) {
        this.op = op; this.left = left; this.right = right;
    }

    public String getOp() { return op; }
    public Expr getLeft() { return left; }
    public Expr getRight() { return right; }
}
