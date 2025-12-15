package com.vyp;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;

import com.vyp.frontend.antlr4.VYPLexer;
import com.vyp.frontend.antlr4.VYPParser;
import com.vyp.util.ErrorReporter;
import com.vyp.frontend.ASTBuilder;
import com.vyp.frontend.ast.Program;
import com.vyp.codegen.CodeGenerator;

/**
 * Simple end-to-end test runner for the CodeGenerator.
 * Reads a source file, parses it, builds the AST and emits VYPcode
 * into an output file for manual inspection.
 */
public class TestCodegen {
    public static void main(String[] args) {
        Path srcPath = (args.length > 0) ? Path.of(args[0]) : Path.of("examples", "factorial.vyp");
        Path outDir = Path.of("out");
        try {
            Files.createDirectories(outDir);
        } catch (IOException e) {
            System.err.println("Failed to create out directory: " + e.getMessage());
            System.exit(1);
        }

        String src;
        try {
            src = Files.readString(srcPath);
        } catch (IOException e) {
            System.err.println("Failed to read source file: " + e.getMessage());
            System.exit(1);
            return;
        }

        ErrorReporter reporter = new ErrorReporter();
        try {
            CharStream cs = CharStreams.fromString(src);
            VYPLexer lexer = new VYPLexer(cs);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            VYPParser parser = new VYPParser(tokens);
            VYPParser.ProgramContext ctx = parser.program();

            if (parser.getNumberOfSyntaxErrors() > 0) {
                System.err.println("Parse had syntax errors; aborting codegen.");
                System.exit(12);
            }

            ASTBuilder builder = new ASTBuilder();
            Program program = (Program) builder.visitProgram(ctx);

            CodeGenerator gen = new CodeGenerator();
            List<String> code = gen.generate(program);

            Path outFile = outDir.resolve(srcPath.getFileName().toString().replaceAll("\\.vyp$", ".vypc"));
            Files.write(outFile, code);

            System.out.println("Generated VYPcode written to: " + outFile.toString());
            // Print first 50 lines for quick inspection
            for (int i = 0; i < Math.min(50, code.size()); i++) {
                System.out.println(code.get(i));
            }

            System.exit(0);
        } catch (ErrorReporter.CompilerException ce) {
            System.err.println(ce.getMessage());
            System.exit(ce.getExitCode());
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Internal error: " + ex.getMessage());
            System.exit(1);
        }
    }
}
