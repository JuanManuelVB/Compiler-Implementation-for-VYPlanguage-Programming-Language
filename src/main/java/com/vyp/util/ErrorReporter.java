package com.vyp.util;

import java.util.ArrayList;
import java.util.List;

public class ErrorReporter {
    private final List<String> errors = new ArrayList<>();
    public void error(String msg) { errors.add(msg); }
    public boolean hasErrors() { return !errors.isEmpty(); }
    public List<String> getErrors() { return errors; }
}
