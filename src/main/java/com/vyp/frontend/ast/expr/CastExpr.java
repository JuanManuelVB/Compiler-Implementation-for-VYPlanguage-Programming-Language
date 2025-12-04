package com.vyp.frontend.ast.expr;

public class CastExpr extends Expr {
    private final String targetType;
    private final Expr expr;

    public CastExpr(String targetType, Expr expr) {
        this.targetType = targetType;
        this.expr = expr;
    }

    public String getTargetType() { return targetType; }
    public Expr getExpr() { return expr; }
}
