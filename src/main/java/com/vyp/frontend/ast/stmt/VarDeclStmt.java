package com.vyp.frontend.ast.stmt;
import com.vyp.frontend.ast.SourceLocation;

import java.lang.reflect.Type;
import java.util.List;
import com.vyp.frontend.ASTVisitor;

public class VarDeclStmt extends Statement {

    private Type type;
    private List<String> varNames;
    
    public VarDeclStmt(Type type, List<String> varNames, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.type = type;
        this.varNames = varNames;
    }
    public Type getType() {
        return type;
    }
    public List<String> getVarNames() {
        return varNames;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }   
    
}
