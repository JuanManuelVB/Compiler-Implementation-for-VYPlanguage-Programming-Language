package com.vyp.frontend.ast.expr;

import com.vyp.frontend.ASTVisitor;
import com.vyp.frontend.ast.SourceLocation;
import com.vyp.semantic.type.Type;
import com.vyp.frontend.ast.ASTNode;

public class Expression extends ASTNode {

    protected Type type;

    //constructor
    public Expression(SourceLocation sourceLocation) {
        super(sourceLocation);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }	

}