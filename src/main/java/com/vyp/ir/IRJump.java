package com.vyp.ir;

public class IRJump implements IRInstruction {
    private final String target;

    public IRJump(String target) { this.target = target; }

    @Override
    public String toIR() { return "JUMP " + target; }
}
