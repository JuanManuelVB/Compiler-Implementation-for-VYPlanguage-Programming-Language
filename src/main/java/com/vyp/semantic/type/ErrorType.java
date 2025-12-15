package com.vyp.semantic.type;


public class ErrorType extends Type {
 
    public static final ErrorType INSTANCE = new ErrorType();

    public ErrorType() {
        super(BasicType.ERROR);
    }

        @Override
    public String toString() {
        return "ERROR";
    }
}
