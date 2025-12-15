package com.vyp.frontend.ast.stmt;
import com.vyp.frontend.ast.SourceLocation;
import com.vyp.frontend.ASTVisitor;
import com.vyp.frontend.ast.ASTNode;

// Abstract class for all statements (it cannot be instantiated, just works as a base class that englobes all the common features of statements)
public abstract class Statement extends ASTNode {

    /**
     * Constructor for Statement
     * @param sourceLocation The source location of the statement (line and column numbers, for error reporting)
     */
    public Statement(SourceLocation sourceLocation) {
        super(sourceLocation);
    }

    /** Abstract method that needs to be redefined for every case of statement */ 
	public abstract <T> T accept(ASTVisitor<T> visitor);

}