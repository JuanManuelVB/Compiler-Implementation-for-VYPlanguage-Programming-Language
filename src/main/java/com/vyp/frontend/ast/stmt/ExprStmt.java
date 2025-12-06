package com.vyp.frontend.ast.stmt;
import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ast.expr.Expr;

public class ExprStmt extends Stmt {
    private Expr expr;

    public ExprStmt(Expr expr, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.expr = expr;
    }

    public Expr getExpr() {
        return expr;
    }
}
