package com.vyp.frontend.ast;

import com.vyp.frontend.ASTVisitor;
import com.vyp.semantic.type.Type;
import com.vyp.frontend.ast.stmt.BlockStmt;
import java.util.List;

public class FunctionDecl extends ASTNode {

    private String name;
    private Type returnType;
    private List<Parameter> params;
    private BlockStmt body;

    public FunctionDecl(String name, Type returnType, List<Parameter> params,
            BlockStmt body, SourceLocation loc) {
        super(loc);
        this.name = name;
        this.returnType = returnType;
        this.params = params;
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public Type getReturnType() {
        return returnType;
    }

    public List<Parameter> getParams() {
        return params;
    }

    public BlockStmt getBody() {
        return body;
    }

    @Override
    public SourceLocation getLocation() {
        return super.getLocation();
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}