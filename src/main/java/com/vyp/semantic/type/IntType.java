package com.vyp.semantic.type;


public class IntType extends Type {
    public static final IntType INSTANCE = new IntType();

    public IntType() {
        super(BasicType.INT);
    }
}
