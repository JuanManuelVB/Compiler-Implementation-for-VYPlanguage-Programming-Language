package com.vyp;

import com.vyp.parser.VYPLexer;
import com.vyp.parser.VYPParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("Usage: java -jar vyp-compiler.jar <input.vyp> [output.vypcode]");
            System.exit(1);
        }

        String in = args[0];
        String out = args.length >= 2 ? args[1] : in + ".vypcode";

        CharStreams.fromFileName(in);
        var input = CharStreams.fromFileName(in);
        VYPLexer lexer = new VYPLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        VYPParser parser = new VYPParser(tokens);
        ParseTree tree = parser.program();

        CodeGenListener gen = new CodeGenListener();
        ParseTreeWalker.DEFAULT.walk(gen, tree);

        Files.writeString(Path.of(out), gen.getCode());
        System.out.println("Generated VYPcode -> " + out);
    }
}
