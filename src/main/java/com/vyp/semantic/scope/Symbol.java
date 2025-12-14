package com.vyp.semantic.scope;

import java.util.List;

import com.vyp.frontend.ast.SourceLocation;
import com.vyp.semantic.type.Type;

public final class Symbol {
    public enum Kind {
        VARIABLE, FUNCTION
    }

    private final String name;
    private final Kind kind;
    private final Type type; // variable: type; function: return type
    private final List<Type> paramTypes; // if kind == FUNCTION
    private final SourceLocation location;

    public static Symbol variable(String name, Type type, SourceLocation location) {
        return new Symbol(name, Kind.VARIABLE, type, null, location);
    }

    public static Symbol function(String name, Type returnType, List<Type> params, SourceLocation location) {
        return new Symbol(name, Kind.FUNCTION, returnType, params, location);
    }

    private Symbol(String name, Kind kind, Type type, java.util.List<Type> paramTypes, SourceLocation location) {
        this.name = name;
        this.kind = kind;
        this.type = type;
        this.paramTypes = new java.util.ArrayList<>(paramTypes);
        this.location = location;
    }

    // getters...
    public String getName() {
        return name;
    }

    public Kind getKind() {
        return kind;
    }

    public Type getType() {
        return type;
    }

    public java.util.List<Type> getParamTypes() {
        return paramTypes;
    }

    public SourceLocation getLocation() {
        return location;
    }

    public boolean isFunction() {
        return kind == Kind.FUNCTION && paramTypes != null;
    }
}
