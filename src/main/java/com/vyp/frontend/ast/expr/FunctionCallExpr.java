package com.vyp.frontend.ast.expr;
import com.vyp.frontend.ast.SourceLocation; 

import java.util.List;

public class FunctionCallExpr extends Expr {
    // Skeleton: function call expression removed
    private String functionName;
    private List<Expr> arguments;

    public FunctionCallExpr(String functionName, List<Expr> arguments, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.functionName = functionName;
        this.arguments = arguments;
    }

    public String getFunctionName() {
        return functionName;
    }

    public List<Expr> getArguments() {
        return arguments;
    }
}