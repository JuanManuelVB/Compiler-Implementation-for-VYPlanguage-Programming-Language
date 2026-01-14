package com.vyp.frontend.ast.expr;
import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ASTVisitor;

public class BinaryOp extends Expression {

    /** Public enum BinaryOperator that includes all the binary operators supported in VYP */
    public enum BinaryOperator {
        ADD, SUB, MUL, DIV,LT, GT, LTE, GTE, EQ, NEQ, AND, OR, CONCAT 
    }   

    private Expression left;    //the left expression of the binary operation
    private Expression right;   //the right expression of the binary operation
    private BinaryOperator operator;  //the binary operator, of type BinaryOperator

    /**
     * Constructor for BinaryOp */
    public BinaryOp(Expression left, Expression right, BinaryOperator operator, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    /** Getters for the expression and the operator */
    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public BinaryOperator getOperator() {
        return operator;
    }

    /** Mehtod accept redefined*/
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}