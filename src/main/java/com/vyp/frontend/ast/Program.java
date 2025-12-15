package com.vyp.frontend.ast;

import com.vyp.frontend.ASTVisitor;
import com.vyp.frontend.ast.expr.Var;

import java.util.List;

// Representation of the entire program in my language
public class Program extends ASTNode {

    private List<FunctionDecl> functions;//the list of function declarations in the program
    private List<Var> globals; // the list of global variable

     /** Constructor for Program */


    public Program(List<Var> globals, List<FunctionDecl> functions, SourceLocation location) {
        super(location);
        this.globals = globals;
        this.functions = functions;
    }

    public Program( List<FunctionDecl> functions, SourceLocation location) {
    super(location);
    this.globals = null;
    this.functions = functions;
    }

    // Getter for functions
    public List<FunctionDecl> getFunctions() {
        return functions;
    }

    public List<Var> getGlobals() { return globals; }

    /** Method accept redefined */
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
