package com.vyp.codegen;

public class LabelManager {
    private int counter = 0;
    public String newLabel(String prefix) { return prefix + (counter++); }
}
