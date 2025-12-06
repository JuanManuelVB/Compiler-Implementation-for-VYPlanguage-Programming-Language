package com.vyp.semantic.type;

public class Type {

    private String typeName;

    public Type(String typeName) {
        this.typeName = typeName;
    }

    public String getName() {
        return typeName;
    }

    @Override
    public String toString() {
        return typeName;
    }
    
    
}
