package com.vyp.semantic.scope;

import java.util.List;

import com.vyp.frontend.ast.SourceLocation;
import com.vyp.semantic.type.Type;

public class Symbol {

    /** Enum class Kind diferenciates if the symbol is a variable or a function.
     * A symbol is a element in the symbol table representing either a variable or a function.
    */
    public enum Kind {
        VARIABLE, FUNCTION
    }

    private String name; // name of the symbol
    private Kind kind; // VARIABLE or FUNCTION
    private Type type; // variable: type; function: return type
    private List<Type> paramTypes; // if kind == FUNCTION
    private SourceLocation location; //for error reporting


    //Constructor for variable and function symbols
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
        if (paramTypes == null) {
            this.paramTypes = new java.util.ArrayList<>();
        } else {
            this.paramTypes = new java.util.ArrayList<>(paramTypes);
        }
        this.location = location;
    }

    // Getters for name, kind, type, paramTypes and location
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

    /** Returns true if it is a function, false if it is a variable */
    public boolean isFunction() {
        return kind == Kind.FUNCTION && paramTypes != null;
    }

    /** Setter for kind */
    public void setKind(Kind kindOfSymbol) {
       this.kind = kindOfSymbol;
    }
}
