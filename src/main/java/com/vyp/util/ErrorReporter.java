package com.vyp.util;

import com.vyp.frontend.ast.SourceLocation;

public class ErrorReporter {

    public class CompilerException extends RuntimeException {
        private final SourceLocation loc;

        public CompilerException(String msg, SourceLocation location) {
            super(msg);
            this.loc = location;
        }

        public SourceLocation getLocation() {
            return loc;
        }
    }

    class DuplicateSymbolException extends CompilerException {

        public DuplicateSymbolException(String msg, SourceLocation location) {
            super(msg, location);

        }
    }

    public void error(SourceLocation location, String string) {
        throw new CompilerException("Error at " + location + ": " + string, location);
    }

}
