package com.vyp.codegen;

public class TempManager {
    private int counter = 0;
    public String newTemp() { return "t" + (counter++); }
}
