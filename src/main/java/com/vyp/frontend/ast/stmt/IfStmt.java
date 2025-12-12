package com.vyp.frontend.ast.stmt;
import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ast.expr.Expression;
import com.vyp.frontend.ASTVisitor;


public class IfStmt extends Statement {

    private Expression condition;
    private BlockStmt ifTrue;
    private BlockStmt ifFalse;

    public IfStmt(Expression condition, BlockStmt ifTrue, BlockStmt ifFalse, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.condition = condition;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }

    public Expression getCondition() {
        return condition;
    }

    public BlockStmt getIfTrue() {
        return ifTrue;
    }

    public BlockStmt getIfFalse() {
        return ifFalse;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {    
        return visitor.visit(this);
    }   
}