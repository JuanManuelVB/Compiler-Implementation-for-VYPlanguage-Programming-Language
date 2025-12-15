package com.vyp.frontend.ast;

import com.vyp.frontend.ASTVisitor;
import com.vyp.frontend.ast.SourceLocation;
	

public abstract class ASTNode {

	private SourceLocation location;

	public ASTNode(SourceLocation location) {
        this.location = location;
    }

	/**
	 * Get source location
	 * @return the location (line and column) in the source code
	 */
	public SourceLocation getLocation(){
		return location;
	}
	
	/**
	 * Set source location
	 * @param sourceLocation the location (line and column) in the source code
	 */
	protected void setSourceLocation(SourceLocation sourceLocation){
		this.location = sourceLocation;
	}


	/**
	 * Accept a visitor. It will call the corresponding visit method in the visitor
	 * This method checks the runtime type of the node and calls the appropriate visit method
	 * Its function is to implement the Visitor design pattern
	 * (Visitor design pattern is a way of separating an algorithm from an object structure on which it operates,
	 *  and it allows adding new operations to existing object structures without modifying those structures)
	 * @param <T>
	 * @param visitor
	 * @return
	 */
    public abstract <T> T accept(ASTVisitor<T> visitor);

}
