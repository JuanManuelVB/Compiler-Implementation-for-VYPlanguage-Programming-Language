package com.vyp.ir;

public class IRReturn implements IRInstruction {
    private final String value; // may be null

    public IRReturn(String value) { this.value = value; }

    @Override
    public String toIR() { return value == null ? "RETURN" : "RETURN " + value; }
}
