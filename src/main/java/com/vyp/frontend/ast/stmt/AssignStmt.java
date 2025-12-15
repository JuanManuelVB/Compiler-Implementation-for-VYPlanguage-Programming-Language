package com.vyp.frontend.ast.stmt;


import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ast.expr.Expression;
import com.vyp.frontend.ASTVisitor;


public class AssignStmt extends Statement {

    private String name;//the name of the variable being assigned
    private Expression value;//the expression whose value is being assigned

     /** Constructor for AssignStmt */
    public AssignStmt(String name, Expression value, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.name = name;
        this.value = value;
    }

    // Getters for name and value
    public String getName() {
        return name;
    }
    public Expression getValue() {
        return value;
    }

    /** Method accept redefined */
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {    
        return visitor.visit(this);
    } 

}
