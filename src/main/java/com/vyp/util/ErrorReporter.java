package com.vyp.util;

import com.vyp.frontend.ast.SourceLocation;
import com.vyp.ExitCodes;

public class ErrorReporter {

    /**
     * Generic compiler exception carrying an exit code and optional source
     * location.
     */
    public static class CompilerException extends RuntimeException {
        private final SourceLocation loc;
        private final int exitCode;

        public CompilerException(String msg, SourceLocation location, int exitCode) {
            super(msg);
            this.loc = location;
            this.exitCode = exitCode;
        }

        public SourceLocation getLocation() {
            return loc;
        }

        public int getExitCode() {
            return exitCode;
        }
    }

    public static class LexicalException extends CompilerException {
        public LexicalException(String msg, SourceLocation loc) {
            super(msg, loc, ExitCodes.LEXICAL_ERROR);
        }
    }

    public static class SyntaxException extends CompilerException {
        public SyntaxException(String msg, SourceLocation loc) {
            super(msg, loc, ExitCodes.SYNTAX_ERROR);
        }
    }

    public static class SemanticTypeException extends CompilerException {
        public SemanticTypeException(String msg, SourceLocation loc) {
            super(msg, loc, ExitCodes.SEMANTIC_TYPE_ERROR);
        }
    }

    public static class SemanticException extends CompilerException {
        public SemanticException(String msg, SourceLocation loc) {
            super(msg, loc, ExitCodes.SEMANTIC_OTHER_ERROR);
        }
    }

    public static class CodegenException extends CompilerException {
        public CodegenException(String msg, SourceLocation loc) {
            super(msg, loc, ExitCodes.CODEGEN_ERROR);
        }
    }

    public static class InternalException extends CompilerException {
        public InternalException(String msg, SourceLocation loc) {
            super(msg, loc, ExitCodes.INTERNAL_ERROR);
        }
    }

    // Convenience methods to throw typed exceptions from analyses
    public void lexical(SourceLocation loc, String msg) {
        throw new LexicalException(format(msg, loc, ExitCodes.LEXICAL_ERROR), loc);
    }

    public void syntax(SourceLocation loc, String msg) {
        throw new SyntaxException(format(msg, loc, ExitCodes.SYNTAX_ERROR), loc);
    }

    public void semanticType(SourceLocation loc, String msg) {
        throw new SemanticTypeException(format(msg, loc, ExitCodes.SEMANTIC_TYPE_ERROR), loc);
    }

    public void semantic(SourceLocation loc, String msg) {
        throw new SemanticException(format(msg, loc, ExitCodes.SEMANTIC_OTHER_ERROR), loc);
    }

    public void codegen(SourceLocation loc, String msg) {
        throw new CodegenException(format(msg, loc, ExitCodes.CODEGEN_ERROR), loc);
    }

    public void internal(SourceLocation loc, String msg) {
        throw new InternalException(format(msg, loc, ExitCodes.INTERNAL_ERROR), loc);
    }

    // Backwards-compatible API: generic error -> semantic other
    public void error(SourceLocation location, String string) {
        semantic(location, string);
    }

    private String format(String msg, SourceLocation loc, int exitCode) {
        String locPrefix = (loc != null ? ("Error at " + loc + ": ") : "Error: ");
        String codeSuffix = exitCode >= 0 ? (" [code=" + exitCode + "]") : "";
        return locPrefix + msg + codeSuffix;
    }

}
