package com.vyp.frontend.ast;

import com.vyp.frontend.ASTVisitor;
import java.util.List;

public class Program extends ASTNode {

    private List<FunctionDecl> functions;
    private List<VarDecl> globals;   // new

    public Program(List<VarDecl> globals, List<FunctionDecl> functions, SourceLocation location) {
        super(location);
        this.globals = globals;
        this.functions = functions;
    }

    public List<FunctionDecl> getFunctions() {
        return functions;
    }

    public List<VarDecl> getGlobals() { return globals; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
