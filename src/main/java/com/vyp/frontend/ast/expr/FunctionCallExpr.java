package com.vyp.frontend.ast.expr;
import com.vyp.frontend.ast.SourceLocation; 
import com.vyp.frontend.ASTVisitor;

import java.util.List;

public class FunctionCallExpr extends Expression {

    private String functionName;
    private List<Expression> arguments;

    public FunctionCallExpr(String functionName, List<Expression> arguments, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.functionName = functionName;
        this.arguments = arguments;
    }

    public String getFunctionName() {
        return functionName;
    }

    public List<Expression> getArguments() {
        return arguments;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}