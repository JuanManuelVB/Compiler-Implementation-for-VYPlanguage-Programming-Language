package com.vyp.frontend.ast.expr;
import com.vyp.frontend.ast.SourceLocation;

public class BinaryOp extends Expr {
    // Skeleton: binary operation removed
    public enum BinaryOperator {
        ADD, SUB, MUL, DIV,LT, GT, LTE, GTE, EQ, NEQ, AND, OR,CONCAT 
    }   
    
    private Expr left;    
    private Expr right;
    private BinaryOperator operator;

    public BinaryOp(Expr left, Expr right, BinaryOperator operator, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public Expr getLeft() {
        return left;
    }

    public Expr getRight() {
        return right;
    }

    public BinaryOperator getOperator() {
        return operator;
    }
}