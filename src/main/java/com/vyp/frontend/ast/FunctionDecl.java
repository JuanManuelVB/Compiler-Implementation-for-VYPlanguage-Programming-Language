package com.vyp.frontend.ast;

import com.vyp.frontend.ASTVisitor;
import com.vyp.semantic.type.Type;
import com.vyp.frontend.ast.stmt.BlockStmt;
import java.util.List;

// Representation of a function declaration in my language
public class FunctionDecl extends ASTNode {

    private String name; //name of the function
    private Type returnType; //return type of the function
    private List<Parameter> params; //list of parameters
    private BlockStmt body; //body of the function

     /** Constructor for FunctionDecl */
    public FunctionDecl(String name, Type returnType, List<Parameter> params,
            BlockStmt body, SourceLocation loc) {
        super(loc);
        this.name = name;
        this.returnType = returnType;
        this.params = params;
        this.body = body;
    }

    // Getters for name, returnType, params, body and location
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

    /** Method accept redefined */
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}