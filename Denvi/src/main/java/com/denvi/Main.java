// package com.denvi;

// import java.io.IOException;
// import java.nio.file.Paths;

// import org.antlr.v4.gui.Trees;
// import org.antlr.v4.runtime.CharStream;
// import org.antlr.v4.runtime.CharStreams;
// import org.antlr.v4.runtime.CommonTokenStream;

// public class Main {

//     private static final String EXTENSION = "dnv";
//     private static final String DIRBASE = "src/test/resources/";

//     public static void main(String[] args) throws IOException {
//         String files[] = args.length == 0 ? new String[]{ "prueba_7." + EXTENSION } : args;
//         System.out.println("Dirbase: " + DIRBASE);

//         for (String file : files) {
//             System.out.println("START: " + file);

//             try {
//                 CharStream in = CharStreams.fromFileName(DIRBASE + file);

//                 denviLexer lexer = new denviLexer(in);
//                 lexer.removeErrorListeners();
//                 lexer.addErrorListener(new DenviErrorListener());

//                 CommonTokenStream tokens = new CommonTokenStream(lexer);
//                 tokens.fill();                                   // aqui truena si hay error lexico

//                 denviParser parser = new denviParser(tokens);
//                 parser.removeErrorListeners();
//                 parser.addErrorListener(new DenviErrorListener());
//                 denviParser.ArchivoContext tree = parser.archivo(); // aqui truena si hay error sintactico

//                 denviCustomVisitor visitor = new denviCustomVisitor();
//                 visitor.directorioBase = Paths.get(DIRBASE).toAbsolutePath().toString();
//                 visitor.visit(tree);                             // aqui truena si hay error semantic
//                 Trees.inspect(tree, parser);

//             } catch (DenviException e) {
//                 System.err.println(e.getMessage());
//             }

//             System.out.println("FINISH: " + file);
//         }
//     }
// }

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