package com.vyp.codegen;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Small utility to generate fresh labels for the code generator.
 * Kept intentionally tiny and human-readable.
 */
public class LabelManager {
    private final AtomicInteger counter = new AtomicInteger(0);

    /** Return a fresh label name (e.g. L1, L2...). */
    public String fresh() {
        return "L" + counter.incrementAndGet();
    }
}
