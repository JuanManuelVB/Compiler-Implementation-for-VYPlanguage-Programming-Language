package com.vyp.frontend.ast.stmt;


import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ast.expr.Expression;
import com.vyp.frontend.ASTVisitor;


public class AssignStmt extends Statement {

    private String name;
    private Expression value;

    public AssignStmt(String name, Expression value, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.name = name;
        this.value = value;
    }
    public String getName() {
        return name;
    }
    public Expression getValue() {
        return value;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {    
        return visitor.visit(this);
    } 

}
