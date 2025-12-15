package com.vyp;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

import com.vyp.frontend.antlr4.VYPLexer;
import com.vyp.frontend.antlr4.VYPParser;
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
            // default small test
            src = "int main(void) { int x; x = 1 + 2; return x; }";
        }
        CharStream cs = CharStreams.fromString(src);
        VYPLexer lexer = new VYPLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        VYPParser parser = new VYPParser(tokens);
        VYPParser.ProgramContext ctx = parser.program();

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
    }
}
