package com.vyp.frontend.ast;

public class SourceLocation {
    
    private final int line;//the line number in which the error occurred
    private final int column;//the column (position in the line) in which the error occurred

    //** Constructor for SourceLocation */
    public SourceLocation(int line, int column) {
        this.line = line;
        this.column = column;
    }

    // Method toString
    @Override public String toString() {
        return "Line " + line + " - Position " + column;
    }   
}
