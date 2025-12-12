package com.vyp.frontend.ast.expr;
import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ASTVisitor;

public class BinaryOp extends Expression {

    public enum BinaryOperator {
        ADD, SUB, MUL, DIV,LT, GT, LTE, GTE, EQ, NEQ, AND, OR,CONCAT 
    }   
    
    private Expression left;    
    private Expression right;
    private BinaryOperator operator;

    public BinaryOp(Expression left, Expression right, BinaryOperator operator, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public BinaryOperator getOperator() {
        return operator;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}