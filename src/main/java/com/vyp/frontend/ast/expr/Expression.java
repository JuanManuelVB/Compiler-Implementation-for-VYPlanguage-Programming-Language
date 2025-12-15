package com.vyp.frontend.ast.expr;

import com.vyp.frontend.ASTVisitor;
import com.vyp.frontend.ast.SourceLocation;
import com.vyp.semantic.type.Type;
import com.vyp.frontend.ast.ASTNode;

//public class that englobes all expressions in VYP
public class Expression extends ASTNode {

    //type of the expression
    protected Type type;

    /**
     * Constructor for Expression
     * @param sourceLocation, the source location of the expression (line and column numbers, for error reporting)
     */
    public Expression(SourceLocation sourceLocation) {
        super(sourceLocation);
    }

    /** Getter for the type of the expression */
    public Type getType() {
        return type;
    }

    /** Setter for the type of the expression */
    public void setType(Type type) {
        this.type = type;
    }

    /** Method accept redefined */
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }	

}