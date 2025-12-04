package com.vyp.ir;

public class IRConcatenation implements IRInstruction {
    private final String dst;
    private final String left;
    private final String right;

    public IRConcatenation(String dst, String left, String right) {
        this.dst = dst; this.left = left; this.right = right;
    }

    @Override
    public String toIR() { return dst + " = CONCAT " + left + " " + right; }
}
