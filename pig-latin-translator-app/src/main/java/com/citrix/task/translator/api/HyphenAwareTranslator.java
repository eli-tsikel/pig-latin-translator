package com.citrix.task.translator.api;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A {@link Translator} decorator that translates hyphen separated word as separated words
 * 
 */
public class HyphenAwareTranslator implements Translator {
    private static final String HYPHEN = "-";

    private Translator translator;

    public HyphenAwareTranslator(Translator translator) {
        this.translator = translator;
    }

    @Override
    public String translate(String word) {
        if (word.contains(HYPHEN)) {
            return Stream.of(word.split(HYPHEN))
                         .map(translator::translate)
                         .collect(Collectors.joining(HYPHEN));

        } else {
            return translator.translate(word);
        }
    }
}
