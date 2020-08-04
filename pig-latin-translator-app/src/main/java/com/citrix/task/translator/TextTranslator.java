package com.citrix.task.translator;

import com.citrix.task.translator.api.Translator;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Translator that reads from the {@link Reader} and writes the translated result to aa {@link Writer}.
 */
public class TextTranslator {
    private final Translator translator;
    
    public TextTranslator(Translator translator) {
        this.translator = translator;
    }

    /**
     * Translates text from <code>in</code> Reader and appends the result to an <code>out</code> Write parameters
     * 
     * @param in input text
     * @param out output
     * @throws IOException
     */
    public void translate(Reader in, Writer out) throws IOException {
        try (var scanner = new Scanner(in)) {
            String translatedText;
            do {
                translatedText = Stream.of(scanner.nextLine().split(" "))
                                       .map(translator::translate)
                                       .filter(Objects::nonNull)
                                       .collect(Collectors.joining(" "));

                if (!isEmpty(translatedText)) {
                    out.append(translatedText);
                    out.append("\n");
                    out.flush();
                }

            } while (!isEmpty(translatedText) && scanner.hasNextLine());
        }
    }

    private boolean isEmpty(String translatedText) {
        return translatedText.isEmpty();
    }
}
