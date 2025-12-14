package com.vyp.semantic.type;

public class Type {

    public enum BasicType {
        INT, STRING, VOID, ERROR
    }

    private BasicType basicType;

    public Type(BasicType basicType) {
        this.basicType = basicType;
    }

    public BasicType getBasicType() {
        return basicType;
    }

    public boolean isErrorType() {
        return basicType == BasicType.ERROR;
    }

    @Override
    public String toString() {
        return basicType.name().toLowerCase();
    }
}