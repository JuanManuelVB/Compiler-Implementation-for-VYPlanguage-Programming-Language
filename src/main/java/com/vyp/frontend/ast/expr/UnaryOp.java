package com.vyp.frontend.ast.expr;

public class UnaryOp extends Expr {
    // Skeleton: unary op removed
    public enum UnaryOperator {
        NOT
    }

    private Expr expression;
    private UnaryOperator operator;

    public UnaryOp(Expr expression, UnaryOperator operator, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.expression = expression;
        this.operator = operator;
    }

    public Expr getExpression() {
        return expression;
    }

    public UnaryOperator getOperator() {
        return operator;
    }
}