package com.vyp.codegen;

import java.util.concurrent.atomic.AtomicInteger;


public class LabelManager {
   
    private int id = 0;

    /** Return a new label name (L1, L2...). */
    public String newLabel() {
        return "L" + id++;
    }
}
