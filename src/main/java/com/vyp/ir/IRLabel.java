package com.vyp.ir;

public class IRLabel implements IRInstruction {
    private final String name;

    public IRLabel(String name) { this.name = name; }

    @Override
    public String toIR() { return name + ":"; }
}
