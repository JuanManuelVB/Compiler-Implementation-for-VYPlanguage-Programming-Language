package com.vyp.semantic.symbol;

import com.vyp.semantic.type.Type;
import java.util.List;

public class FunctionSymbol implements Symbol {
    private final String name;
    private final Type returnType;
    private final List<VariableSymbol> params;

    public FunctionSymbol(String name, Type returnType, List<VariableSymbol> params) {
        this.name = name; this.returnType = returnType; this.params = params;
    }
    @Override public String getName() { return name; }
    public Type getReturnType() { return returnType; }
    public List<VariableSymbol> getParams() { return params; }
}
