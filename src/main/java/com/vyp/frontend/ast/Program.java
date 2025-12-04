package com.vyp.frontend.ast;

import java.util.List;

public class Program implements ASTNode {
    private final List<FunctionDecl> functions;

    public Program(List<FunctionDecl> functions) {
        this.functions = functions;
    }

    public List<FunctionDecl> getFunctions() {
        return functions;
    }
}
