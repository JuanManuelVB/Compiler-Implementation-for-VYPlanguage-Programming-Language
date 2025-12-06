package com.vyp.frontend.ast;

public class SourceLocation {
    
    private final int line;
    private final int column;

    public SourceLocation(int line, int column) {
        this.line = line;
        this.column = column;
    }

    @Override public String toString() {
        return "Line " + line + ", Column " + column;
    }   
}
