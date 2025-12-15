package com.vyp.frontend.ast.expr;
import com.vyp.frontend.ast.SourceLocation; 
import com.vyp.frontend.ASTVisitor;

import java.util.List;

public class FunctionCallExpr extends Expression {

    private String functionName; //name of the function being called
    private List<Expression> arguments; //list of argument expressions passed to the function

     /**
     * Constructor for FunctionCallExpr */
    public FunctionCallExpr(String functionName, List<Expression> arguments, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.functionName = functionName;
        this.arguments = arguments;
    }

    /** Getter methods for function name and arguments */
    public String getFunctionName() {
        return functionName;
    }

    public List<Expression> getArguments() {
        return arguments;
    }

    /** Method accept redefined */
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}