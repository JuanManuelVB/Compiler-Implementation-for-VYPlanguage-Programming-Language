package com.vyp.ir;

public class IRCast implements IRInstruction {
    private final String dst;
    private final String src;
    private final String targetType;

    public IRCast(String dst, String src, String targetType) {
        this.dst = dst; this.src = src; this.targetType = targetType;
    }

    @Override
    public String toIR() { return dst + " = CAST(" + targetType + ") " + src; }
}
