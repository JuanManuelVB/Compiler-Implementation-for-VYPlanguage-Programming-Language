package com.vyp.frontend.ast;

import com.vyp.frontend.ASTVisitor;
import com.vyp.frontend.ast.SourceLocation;
	

public abstract class ASTNode {

	private SourceLocation location;//the location (line and column) in the source code , for error reporting

	/** Constructor for ASTNode*/
	public ASTNode(SourceLocation location) {
        this.location = location;
    }

	// Getter and setter for source location
	public SourceLocation getLocation(){
		return location;
	}
	
	protected void setSourceLocation(SourceLocation sourceLocation){
		this.location = sourceLocation;
	}

	/**
	 * Accept a visitor. It will call the corresponding visit method in the visitor
	 * This method checks the runtime type of the node and calls the appropriate visit method
	 *  Its function is to implement the Visitor design pattern */
    public abstract <T> T accept(ASTVisitor<T> visitor);

}
