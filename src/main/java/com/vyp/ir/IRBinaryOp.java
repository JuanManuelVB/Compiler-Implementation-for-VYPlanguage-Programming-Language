package com.vyp.ir;

public class IRBinaryOp implements IRInstruction {
    private final String op;
    private final String dst, lhs, rhs;

    public IRBinaryOp(String op, String dst, String lhs, String rhs) {
        this.op = op;
        this.dst = dst;
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public String toIR() {
        return dst + " = " + lhs + " " + op + " " + rhs;
    }
}
