package com.vyp.frontend.ast.stmt;
import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ast.expr.Expression;
import com.vyp.frontend.ASTVisitor;


public class IfStmt extends Statement {

    private Expression condition;//the condition expression
    private BlockStmt ifTrue;//the block executed if condition is true (then branch)
    private BlockStmt ifFalse;//the block executed if condition is false (else branch), can be null

     /** Constructor for IfStmt */
    public IfStmt(Expression condition, BlockStmt ifTrue, BlockStmt ifFalse, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.condition = condition;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }

    // Getters for condition, ifTrue, and ifFalse
    public Expression getCondition() {
        return condition;
    }

    public BlockStmt getIfTrue() {
        return ifTrue;
    }

    public BlockStmt getIfFalse() {
        return ifFalse;
    }

    /** Method accept redefined */
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {    
        return visitor.visit(this);
    }   
}