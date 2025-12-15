package com.vyp.frontend.ast;

import com.vyp.frontend.ASTVisitor;
import com.vyp.frontend.ast.expr.Var;

import java.util.List;

public class Program extends ASTNode {

    private List<FunctionDecl> functions;
    private List<Var> globals;   // new

    public Program(List<Var> globals, List<FunctionDecl> functions, SourceLocation location) {
        super(location);
        this.globals = globals;
        this.functions = functions;
    }

    public List<FunctionDecl> getFunctions() {
        return functions;
    }

    public List<Var> getGlobals() { return globals; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
