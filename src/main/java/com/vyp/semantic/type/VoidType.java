package com.vyp.semantic.type;

public class VoidType extends Type {
    public static final VoidType INSTANCE = new VoidType();

    public VoidType() {
        super(BasicType.VOID);
    }
}
