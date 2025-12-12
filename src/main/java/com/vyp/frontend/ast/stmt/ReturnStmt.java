package com.vyp.frontend.ast.stmt;
import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ast.expr.Expression;
import com.vyp.frontend.ASTVisitor;

public class ReturnStmt extends Statement {
    private Expression value;

    public ReturnStmt(Expression value, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.value = value;
    }

    public Expression getValue() {
        return value;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}   