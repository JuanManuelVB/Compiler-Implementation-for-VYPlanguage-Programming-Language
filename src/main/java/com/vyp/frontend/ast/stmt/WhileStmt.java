package com.vyp.frontend.ast.stmt;

import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ast.expr.Expression;
import com.vyp.frontend.ASTVisitor;

public class WhileStmt extends Statement {

    private Expression condition;//the condition expression
    private BlockStmt body;//the block executed while condition is true

     /** Constructor for WhileStmt */
    public WhileStmt(Expression condition, BlockStmt body, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.condition = condition;
        this.body = body;
    }

    // Getters for condition and body
    public Expression getCondition() {
        return condition;
    }

    public BlockStmt getBody() {
        return body;
    }

    /** Method accept redefined */
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }   
}