package com.vyp.frontend.ast.stmt;

import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ast.expr.Expression;
import com.vyp.frontend.ASTVisitor;

public class WhileStmt extends Statement {

    private Expression condition;
    private BlockStmt body;

    public WhileStmt(Expression condition, BlockStmt body, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.condition = condition;
        this.body = body;
    }

    public Expression getCondition() {
        return condition;
    }

    public BlockStmt getBody() {
        return body;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }   
}