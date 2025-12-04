package com.vyp.frontend.ast.stmt;

public class VarDeclStmt extends Stmt {
    private final String name;
    private final com.vyp.frontend.ast.expr.Expr init;

    public VarDeclStmt(String name, com.vyp.frontend.ast.expr.Expr init) {
        this.name = name;
        this.init = init;
    }

    public String getName() { return name; }
    public com.vyp.frontend.ast.expr.Expr getInit() { return init; }
}
