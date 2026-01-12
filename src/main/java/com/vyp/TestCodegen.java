package com.vyp;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.vyp.frontend.antlr4.VYPLexer;
import com.vyp.frontend.antlr4.VYPParser;
import com.vyp.frontend.ASTBuilder;
import com.vyp.frontend.ast.Program;
import com.vyp.codegen.CodeGenerator;


public class TestCodegen {
    public static void main(String[] args) throws Exception {
        // Usage: TestCodegen [input.vyp] [output.vypcode]
        Path src;
        Path out = null;

        if (args.length >= 1) {
            src = Path.of(args[0]);
        } else {
            src = Path.of("examples", "factorial.vyp");
        }

        if (args.length >= 2) {
            out = Path.of(args[1]);
        }

        String input = Files.readString(src);

        CharStream cs = CharStreams.fromString(input);
        VYPLexer lexer = new VYPLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        VYPParser parser = new VYPParser(tokens);
        VYPParser.ProgramContext ctx = parser.program();

        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.err.println("Parse errors; aborting.");
            return;
        }

        Program program = (Program) new ASTBuilder().visitProgram(ctx);
        List<String> code = new CodeGenerator().generate(program);

        if (out != null) {
            // ensure parent directory exists
            Path parent = out.getParent();
            if (parent != null) Files.createDirectories(parent);
            Files.writeString(out, String.join(System.lineSeparator(), code), StandardCharsets.UTF_8);
            System.err.println("Wrote generated VYPcode to: " + out.toString());
        } else {
            code.forEach(System.out::println);
        }
    }
}  
