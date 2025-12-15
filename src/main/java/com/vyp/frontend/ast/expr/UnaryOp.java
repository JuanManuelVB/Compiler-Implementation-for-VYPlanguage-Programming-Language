package com.vyp.frontend.ast.expr;

import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ASTVisitor;

public class UnaryOp extends Expression {

    /** Enum for unary operators. It just accepts NOT */
    public enum UnaryOperator {
        NOT,
        PLUS,
        MINUS
    }

    private Expression expression; //the expression on which the unary operation is applied
    private UnaryOperator operator; //the unary operator, of type NOT

     /** Constructor for UnaryOp */
    public UnaryOp(Expression expression, UnaryOperator operator, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.expression = expression;
        this.operator = operator;
    }

    // Getters for the expression and the operator
    public Expression getExpression() {
        return expression;
    }

    public UnaryOperator getOperator() {
        return operator;
    }

    /** Method accept redefined */
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {    
        return visitor.visit(this);
    }   
}