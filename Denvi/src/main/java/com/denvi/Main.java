package com.denvi;

import java.io.IOException;
import java.nio.file.Paths;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {

    private static final String DIRBASE = "src/test/resources/";

    public static void main(String[] args) throws IOException {
        String archivo = args.length == 0 ? "prueba_7.dnv" : args[0];

        try {
            denviLexer lexer = new denviLexer(CharStreams.fromFileName(DIRBASE + archivo));
            lexer.removeErrorListeners();
            lexer.addErrorListener(new DenviErrorListener());

            denviParser parser = new denviParser(new CommonTokenStream(lexer));
            parser.removeErrorListeners();
            parser.addErrorListener(new DenviErrorListener());

            denviCustomVisitor visitor = new denviCustomVisitor();
            visitor.directorioBase = Paths.get(DIRBASE).toAbsolutePath().toString();
            visitor.visit(parser.archivo());
        } catch (DenviException e) {
            System.err.println(e.getMessage());
        }
    }
}