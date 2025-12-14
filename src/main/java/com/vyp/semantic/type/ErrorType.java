package com.vyp.semantic.type;

import com.vyp.semantic.type.Type.BasicType;

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
