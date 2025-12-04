package com.vyp.frontend.ast;

import java.util.List;

public class FunctionDecl implements ASTNode {
    private final String name;
    private final List<Parameter> parameters;
    private final BlockStmt body;

    public FunctionDecl(String name, List<Parameter> parameters, BlockStmt body) {
        this.name = name;
        this.parameters = parameters;
        this.body = body;
    }

    public String getName() { return name; }
    public List<Parameter> getParameters() { return parameters; }
    public BlockStmt getBody() { return body; }
}
