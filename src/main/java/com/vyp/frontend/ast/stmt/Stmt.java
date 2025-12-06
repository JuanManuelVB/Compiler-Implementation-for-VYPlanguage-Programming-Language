package com.vyp.frontend.ast.stmt;
import com.vyp.frontend.ast.SourceLocation;

import com.vyp.frontend.ast.ASTNode;

public abstract class Stmt implements ASTNode {
	// Skeleton: statement base
	private SourceLocation sourceLocation;

    public Stmt(SourceLocation sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public SourceLocation getSourceLocation() {
        return sourceLocation;
    }

	public void setSourceLocation(SourceLocation sourceLocation) {
		this.sourceLocation = sourceLocation;
	}

	//public abstract <T> T accept(AstVisitor<T> visitor);

}