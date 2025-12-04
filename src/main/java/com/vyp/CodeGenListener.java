package com.vyp;

import com.vyp.parser.VYPBaseListener;
import com.vyp.parser.VYPParser;

import java.util.ArrayList;
import java.util.List;

public class CodeGenListener extends VYPBaseListener {
    private final List<String> code = new ArrayList<>();

    @Override
    public void enterStatement(VYPParser.StatementContext ctx) {
        String val = ctx.expr().getText();
        code.add("PUSH " + val);
        code.add("WRITE");
    }

    public String getCode() {
        return String.join(System.lineSeparator(), code);
    }
}
