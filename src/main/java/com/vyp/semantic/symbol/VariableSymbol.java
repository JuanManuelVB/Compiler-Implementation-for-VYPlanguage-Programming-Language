package com.vyp.semantic.symbol;

import com.vyp.semantic.type.Type;

public class VariableSymbol implements Symbol {
    private final String name;
    private final Type type;

    public VariableSymbol(String name, Type type) { this.name = name; this.type = type; }
    @Override public String getName() { return name; }
    public Type getType() { return type; }
}
