package com.vyp.frontend.ast.stmt;
import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ASTVisitor;


import com.vyp.frontend.ast.ASTNode;

public abstract class Statement extends ASTNode {


    public Statement(SourceLocation sourceLocation) {
        super(sourceLocation);
    }


	public abstract <T> T accept(ASTVisitor<T> visitor);

}