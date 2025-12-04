package com.vyp.ir;

public class IRStoreVar implements IRInstruction {
    private final String varName;
    private final String src;

    public IRStoreVar(String varName, String src) { this.varName = varName; this.src = src; }

    @Override
    public String toIR() { return "STORE " + varName + " " + src; }
}
