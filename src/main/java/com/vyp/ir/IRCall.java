package com.vyp.ir;

import java.util.List;
import java.util.stream.Collectors;

public class IRCall implements IRInstruction {
    private final String dst; // may be null for void calls
    private final String name;
    private final List<String> args;

    public IRCall(String dst, String name, List<String> args) {
        this.dst = dst; this.name = name; this.args = args;
    }

    @Override
    public String toIR() {
        String a = args == null ? "" : args.stream().collect(Collectors.joining(", "));
        if (dst == null) return "CALL " + name + " " + a;
        return dst + " = CALL " + name + " " + a;
    }
}
