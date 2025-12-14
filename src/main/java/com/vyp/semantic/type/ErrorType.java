package com.vyp.semantic.type;

public class ErrorType extends Type {

    public ErrorType(BasicType basicType) {
        super(BasicType.ERROR);
    }

    @Override
    public String toString() {
        return "ERROR";
    }




}
