package com.vyp.semantic.type;

public class ErrorType implements Type {
    private final String message;
    public ErrorType(String message) { this.message = message; }
    @Override public String getName() { return "error: " + message; }
}
