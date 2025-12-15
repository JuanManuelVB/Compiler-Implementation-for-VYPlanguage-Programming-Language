package com.vyp;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import com.vyp.frontend.antlr4.VYPLexer;
import com.vyp.frontend.antlr4.VYPParser;
import com.vyp.frontend.ASTBuilder;
import com.vyp.frontend.ASTPrinter;
import com.vyp.frontend.ast.Program;
import com.vyp.semantic.scope.SymbolTable;
import com.vyp.semantic.scope.Symbol;
import com.vyp.semantic.type.IntType;

/** Minimal, easy-to-read smoke test:
 *  - reads a source (arg or examples/bad.vyp)
 *  - parses and builds AST
 *  - prints function count, AST, and a small symbol-table check
 */
public class TestASTAndSymbols {
    public static void main(String[] args) throws Exception {
        Path srcPath =Path.of("examples", "bad.vyp");
        String src = Files.readString(srcPath);

        CharStream cs = CharStreams.fromString(src);
        VYPLexer lexer = new VYPLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        VYPParser parser = new VYPParser(tokens);
        VYPParser.ProgramContext ctx = parser.program();

        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.err.println("Parse errors detected — aborting test.");
            return;
        }

        Program program = (Program) new ASTBuilder().visitProgram(ctx);
        System.out.println("Parsed functions: " + program.getFunctions().size());

        // Print AST
        new ASTPrinter().visit(program);

        // Simple symbol table smoke test
        SymbolTable table = new SymbolTable();
        Symbol s = Symbol.variable("x", IntType.INSTANCE, null);
        table.addToScope(s);
        System.out.println("Symbol 'x' resolved: " + (Objects.nonNull(table.resolve("x"))));
    }
}
