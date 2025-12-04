package com.vyp.frontend.ast.stmt;

public class AssignStmt extends Stmt {
    private final String target;
    private final com.vyp.frontend.ast.expr.Expr value;

    public AssignStmt(String target, com.vyp.frontend.ast.expr.Expr value) {
        this.target = target;
        this.value = value;
    }

    public String getTarget() { return target; }
    public com.vyp.frontend.ast.expr.Expr getValue() { return value; }
}
