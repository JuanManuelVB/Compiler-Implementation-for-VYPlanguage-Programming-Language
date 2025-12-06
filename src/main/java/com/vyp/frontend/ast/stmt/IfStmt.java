package com.vyp.frontend.ast.stmt;
import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ast.expr.Expr;


public class IfStmt extends Stmt {
    // Skeleton: if statement removed
    private Expr condition;
    private BlockStmt ifTrue;
    private BlockStmt ifFalse;

    public IfStmt(Expr condition, BlockStmt ifTrue, BlockStmt ifFalse, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.condition = condition;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }

    public Expr getCondition() {
        return condition;
    }

    public BlockStmt getIfTrue() {
        return ifTrue;
    }

    public BlockStmt getIfFalse() {
        return ifFalse;
    }
}