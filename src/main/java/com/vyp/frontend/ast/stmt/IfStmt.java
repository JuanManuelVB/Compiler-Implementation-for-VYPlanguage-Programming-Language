package com.vyp.frontend.ast.stmt;

public class IfStmt extends Stmt {
    private final com.vyp.frontend.ast.expr.Expr condition;
    private final Stmt thenBranch;
    private final Stmt elseBranch;

    public IfStmt(com.vyp.frontend.ast.expr.Expr condition, Stmt thenBranch, Stmt elseBranch) {
        this.condition = condition;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
    }

    public com.vyp.frontend.ast.expr.Expr getCondition() { return condition; }
    public Stmt getThenBranch() { return thenBranch; }
    public Stmt getElseBranch() { return elseBranch; }
}
