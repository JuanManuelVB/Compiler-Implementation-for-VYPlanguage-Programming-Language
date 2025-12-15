package com.vyp.frontend.ast.stmt;
import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ast.expr.Expression;
import com.vyp.frontend.ASTVisitor;


public class ExprStmt extends Statement {
    
    private Expression expr;//the expression being evaluated

     /** Constructor for ExprStmt */
    public ExprStmt(Expression expr, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.expr = expr;
    }

    // Getter for expr
    public Expression getExpr() {
        return expr;
    }

    /** Method accept redefined */
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {    
        return visitor.visit(this);
    }
}
