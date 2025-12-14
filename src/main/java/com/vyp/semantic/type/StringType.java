package com.vyp.semantic.type;

public class StringType extends Type {
    public static final StringType INSTANCE = new StringType();

    public StringType() {
        super(BasicType.STRING);
    }
}
