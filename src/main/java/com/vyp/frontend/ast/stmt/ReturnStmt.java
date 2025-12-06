package com.vyp.frontend.ast.stmt;
import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ast.expr.Expr;

public class ReturnStmt extends Stmt {
    private Expr value;

    public ReturnStmt(Expr value, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.value = value;
    }

    public Expr getValue() {
        return value;
    }
}   