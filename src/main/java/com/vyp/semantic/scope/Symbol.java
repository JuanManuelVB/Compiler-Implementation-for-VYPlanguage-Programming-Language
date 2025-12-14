package com.vyp.semantic.scope;

public final class Symbol {
    public enum Kind { VARIABLE, FUNCTION }

    private final String name;
    private final Kind kind;
    private final Type type;                   // variable: su tipo; función: tipo retorno
    private final java.util.List<Type> paramTypes; // solo si kind == FUNCTION
    private final Position pos;

    public static Symbol variable(String name, Type type, Position pos) {
        return new Symbol(name, Kind.VARIABLE, type, java.util.List.of(), pos);
    }
    public static Symbol function(String name, Type returnType, java.util.List<Type> params, Position pos) {
        return new Symbol(name, Kind.FUNCTION, returnType, params, pos);
    }

    private Symbol(String name, Kind kind, Type type, java.util.List<Type> paramTypes, Position pos) {
        this.name = name;
        this.kind = kind;
        this.type = type;
        this.paramTypes = new java.util.ArrayList<>(paramTypes);
        this.pos = pos;
    }

    // getters...
    public String getName() { return name; }
    public Kind getKind() { return kind; }
    public Type getType() { return type; }
    public java.util.List<Type> getParamTypes() { return paramTypes; }
    public Position getPos() { return pos; }

    // Temporary placeholder types to make this file self-contained; replace with real implementations later.
    public static final class Type { }
    public static final class Position { }
}
