package com.vyp.frontend.ast.stmt;
import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ast.expr.Expression;
import com.vyp.frontend.ASTVisitor;

public class ReturnStmt extends Statement {
    
    private Expression value;//the expression whose value is being returned

     /** Constructor for ReturnStmt */
    public ReturnStmt(Expression value, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.value = value;
    }

    // Getter for value
    public Expression getValue() {
        return value;
    }

    /** Method accept redefined */
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}   