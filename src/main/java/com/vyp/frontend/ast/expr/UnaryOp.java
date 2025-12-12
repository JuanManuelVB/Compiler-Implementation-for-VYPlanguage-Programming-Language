package com.vyp.frontend.ast.expr;

import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ASTVisitor;

public class UnaryOp extends Expression {

    public enum UnaryOperator {
        NOT
    }

    private Expression expression;
    private UnaryOperator operator;

    public UnaryOp(Expression expression, UnaryOperator operator, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.expression = expression;
        this.operator = operator;
    }

    public Expression getExpression() {
        return expression;
    }

    public UnaryOperator getOperator() {
        return operator;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {    
        return visitor.visit(this);
    }   
}