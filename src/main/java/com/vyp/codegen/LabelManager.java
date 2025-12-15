package com.vyp.codegen;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Small utility to generate fresh labels for the code generator.
 * Kept intentionally tiny and human-readable.
 */
public class LabelManager {
    private final AtomicInteger counter = new AtomicInteger(0);

    /**
     * Return a fresh label with a short default purpose prefix.
     * Example: __gen_L_1
     */
    public String fresh() {
        return fresh("L");
    }

    /**
     * Return a fresh label using a purpose-based prefix. The purpose string
     * is sanitized (non-alphanumeric turned to '_') and truncated to keep
     * labels readable. Example: __gen_if_1 or __gen_while_end_5
     */
    public String fresh(String purpose) {
        String p = (purpose == null) ? "gen" : purpose.replaceAll("[^A-Za-z0-9_]", "_");
        if (p.length() > 20) p = p.substring(0, 20);
        return "__gen_" + p + "_" + counter.incrementAndGet();
    }
}