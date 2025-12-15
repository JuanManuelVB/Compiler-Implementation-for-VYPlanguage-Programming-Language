package com.vyp;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

import com.vyp.frontend.antlr4.VYPLexer;
import com.vyp.frontend.antlr4.VYPParser;
import com.vyp.util.ErrorReporter;
import com.vyp.frontend.ASTBuilder;
import com.vyp.frontend.ASTPrinter;
import com.vyp.frontend.ast.Program;
import com.vyp.semantic.scope.SymbolTable;
import com.vyp.semantic.scope.Symbol;
import com.vyp.semantic.type.IntType;
import com.vyp.frontend.ast.SourceLocation;

public class TestASTAndSymbols {
    public static void main(String[] args) {
        String src = null;
        if (args.length > 0) {
            try {
                src = Files.readString(Path.of(args[0]));
            } catch (IOException e) {
                System.err.println("Failed to read input file: " + e.getMessage());
                return;
            }
        } else {
            // Try to load an example that contains a deliberate syntax error for testing the ErrorReporter
            Path example = Path.of("examples", "bad.vyp");
            if (Files.exists(example)) {
                try {
                    src = Files.readString(example);
                } catch (IOException e) {
                    System.err.println("Failed to read example file, falling back to inline test: " + e.getMessage());
                    src = "int main(void) { int x; x = 1 + 2; return x; }";
                }
            } else {
                // default small test
                src = "int main(void) { int x; x = 1 + 2; return x; }";
            }
        }
        ErrorReporter reporter = new ErrorReporter();

        try {
            CharStream cs = CharStreams.fromString(src);
            VYPLexer lexer = new VYPLexer(cs);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            VYPParser parser = new VYPParser(tokens);
            VYPParser.ProgramContext ctx = null;
            try {
                ctx = parser.program();
            } catch (RuntimeException re) {
                // Lexer/driver/runtime exceptions surface as RuntimeException
                reporter.lexical(null, "Lexical error: " + re.getMessage());
            }

            if (parser.getNumberOfSyntaxErrors() > 0) {
                reporter.syntax(null, "Syntax errors during parse (see stderr)");
            }

            if (ctx == null) {
                reporter.internal(null, "Parser returned null parse tree");
            }

            ASTBuilder builder = new ASTBuilder();
            Program program = (Program) builder.visitProgram(ctx);
            System.out.println("Parsed program. Functions: " + program.getFunctions().size());

            // Print AST structure
            ASTPrinter printer = new ASTPrinter();
            program.accept(printer);

            // Symbol table smoke test
            SymbolTable table = new SymbolTable();
            Symbol s = Symbol.variable("x", IntType.INSTANCE, new SourceLocation(1,1));
            boolean added = table.addToScope(s);
            Symbol res = table.resolve("x");
            System.out.println("Symbol added=" + added + ", resolved=" + (res != null));
            boolean addedAgain = table.addToScope(Symbol.variable("x", IntType.INSTANCE, new SourceLocation(1,1)));
            System.out.println("Adding duplicate returned: " + addedAgain);

            System.exit(ExitCodes.SUCCESS);
        } catch (ErrorReporter.CompilerException ce) {
            System.err.println(ce.getMessage());
            System.exit(ce.getExitCode());
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Internal compiler error: " + ex.getMessage());
            System.exit(ExitCodes.INTERNAL_ERROR);
        }
    }
}
