package com.vyp.ir;

public class IRLoadVar implements IRInstruction {
    private final String dst;
    private final String varName;

    public IRLoadVar(String dst, String varName) { this.dst = dst; this.varName = varName; }

    @Override
    public String toIR() { return dst + " = LOAD " + varName; }
}
