package com.vyp.frontend.ast.stmt;

public class ReturnStmt extends Stmt {
    private final com.vyp.frontend.ast.expr.Expr value;

    public ReturnStmt(com.vyp.frontend.ast.expr.Expr value) {
        this.value = value;
    }

    public com.vyp.frontend.ast.expr.Expr getValue() { return value; }
}
