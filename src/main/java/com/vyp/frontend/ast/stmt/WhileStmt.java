package com.vyp.frontend.ast.stmt;
import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ast.expr.Expr;

public class WhileStmt extends Stmt {
    // Skeleton: while statement removed
    private Expr condition;
    private BlockStmt body;

    public WhileStmt(Expr condition, BlockStmt body, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.condition = condition;
        this.body = body;
    }

    public Expr getCondition() {
        return condition;
    }

    public BlockStmt getBody() {
        return body;
    }
}