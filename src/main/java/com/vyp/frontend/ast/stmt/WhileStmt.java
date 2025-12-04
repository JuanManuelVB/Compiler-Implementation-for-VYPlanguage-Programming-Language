package com.vyp.frontend.ast.stmt;

public class WhileStmt extends Stmt {
    private final com.vyp.frontend.ast.expr.Expr condition;
    private final Stmt body;

    public WhileStmt(com.vyp.frontend.ast.expr.Expr condition, Stmt body) {
        this.condition = condition;
        this.body = body;
    }

    public com.vyp.frontend.ast.expr.Expr getCondition() { return condition; }
    public Stmt getBody() { return body; }
}
