package com.vyp.ir;

public class IRUnaryOp implements IRInstruction {
    private final String op;
    private final String dst, src;

    public IRUnaryOp(String op, String dst, String src) {
        this.op = op; this.dst = dst; this.src = src;
    }

    @Override
    public String toIR() { return dst + " = " + op + " " + src; }
}
