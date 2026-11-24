package com.denvi;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class DenviErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e) {
        if (recognizer instanceof Lexer) {
            CharStream cs = ((Lexer) recognizer).getInputStream();
            String archivo = DenviException.nombreArchivo(cs.getSourceName());
            throw new DenviException.ErrorLexico(line, charPositionInLine, msg, archivo).conCodigo(cs);
        }
        CharStream cs = null;
        String archivo = "<entrada>";
        if (recognizer instanceof Parser) {
            cs = ((Parser) recognizer).getInputStream().getTokenSource().getInputStream();
            archivo = DenviException.nombreArchivo(((Parser) recognizer).getInputStream().getSourceName());
        }
        throw new DenviException.ErrorSintactico(line, charPositionInLine, msg, archivo).conCodigo(cs);
    }
}