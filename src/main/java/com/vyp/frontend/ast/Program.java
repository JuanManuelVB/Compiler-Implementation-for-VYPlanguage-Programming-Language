package com.vyp.frontend.ast;

import com.vyp.frontend.ASTVisitor;
import java.util.List;

// Representation of the entire program in my language
public class Program extends ASTNode {

    private List<FunctionDecl> functions;//the list of function declarations in the program

     /** Constructor for Program */
    public Program(List<FunctionDecl> functions, SourceLocation location) {
        super(location);
        this.functions = functions;
    }

    // Getter for functions
    public List<FunctionDecl> getFunctions() {
        return functions;
    }

    /** Method accept redefined */
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
