package com.vyp.frontend.ast.stmt;
import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ast.expr.Expr;

public class AssignStmt extends Stmt {
    // Skeleton: assign statement removed
    private String name;
    private Expr value;

    public AssignStmt(String name, Expr value, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.name = name;
        this.value = value;
    }
    public String getName() {
        return name;
    }
    public Expr getValue() {
        return value;
    }
    

}
