package com.vyp.frontend.ast.stmt;
import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ast.expr.Expression;
import com.vyp.frontend.ASTVisitor;


public class ExprStmt extends Statement {
    private Expression expr;

    public ExprStmt(Expression expr, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.expr = expr;
    }

    public Expression getExpr() {
        return expr;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {    
        return visitor.visit(this);
    }
}
