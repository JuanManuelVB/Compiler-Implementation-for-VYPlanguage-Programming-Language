package com.vyp.frontend.ast.stmt;

public class ExprStmt extends Stmt {
    private final com.vyp.frontend.ast.expr.Expr expr;

    public ExprStmt(com.vyp.frontend.ast.expr.Expr expr) {
        this.expr = expr;
    }

    public com.vyp.frontend.ast.expr.Expr getExpr() { return expr; }
}
