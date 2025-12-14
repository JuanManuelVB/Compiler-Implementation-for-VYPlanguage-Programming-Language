package com.vyp.frontend.ast;

import com.vyp.frontend.ASTVisitor;
import java.util.List;

public class Program extends ASTNode {

    private List<FunctionDecl> functions;

    public Program(List<FunctionDecl> functions, SourceLocation location) {
        super(location);
        this.functions = functions;
    }

    public List<FunctionDecl> getFunctions() {
        return functions;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
