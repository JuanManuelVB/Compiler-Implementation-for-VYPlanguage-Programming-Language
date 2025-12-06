package com.vyp.frontend.ast.expr;

import com.vyp.frontend.ast.ASTNode;
import com.vyp.frontend.ast.SourceLocation;
import com.vyp.semantic.type.Type;

public class Expr implements ASTNode {

	//constructor
	public Expr(SourceLocation sourceLocation) {
		this.sourceLocation = sourceLocation;
	}

	private SourceLocation sourceLocation;

	protected Type type;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}


	@Override
	public SourceLocation getSourceLocation() {
		return sourceLocation;
	}

	@Override
	public void setSourceLocation(SourceLocation sourceLocation) {
		this.sourceLocation = sourceLocation;
	}

}
