package com.vyp.ir;

public class IRCondJump implements IRInstruction {
    private final String condition; // variable or temp holding boolean/int
    private final String target;

    public IRCondJump(String condition, String target) {
        this.condition = condition;
        this.target = target;
    }

    @Override
    public String toIR() { return "CJUMP " + condition + " " + target; }
}
