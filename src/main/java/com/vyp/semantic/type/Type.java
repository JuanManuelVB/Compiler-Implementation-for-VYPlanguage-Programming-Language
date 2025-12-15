package com.vyp.semantic.type;

public class Type {

    /** Enum BasicType defines the basic types available in VYP language */
    public enum BasicType {
        INT, STRING, VOID, ERROR
    }

    private BasicType basicType; // basic type of the Type


    //Constructor for Type
    public Type(BasicType basicType) {
        this.basicType = basicType;
    }

    // Getter for basicType
    public BasicType getBasicType() {
        return basicType;
    }

    /**
     * Checks if the type is an error type
     * @return true if the type is ERROR, false otherwise
     */
    public boolean isErrorType() {
        return basicType == BasicType.ERROR;
    }


    /** toString method overridden to return the string representation of the type */
    @Override
    public String toString() {
        return basicType.name().toLowerCase();
    }
}