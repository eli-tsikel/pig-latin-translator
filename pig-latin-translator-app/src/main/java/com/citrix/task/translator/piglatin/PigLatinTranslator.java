package com.citrix.task.translator.piglatin;

import com.citrix.task.translator.api.HyphenAwareTranslator;
import com.citrix.task.translator.api.Rule;
import com.citrix.task.translator.api.Translator;
import com.citrix.task.translator.piglatin.rules.CapitalizationRule;
import com.citrix.task.translator.piglatin.rules.ConsonantRule;
import com.citrix.task.translator.piglatin.rules.PunctuationRule;
import com.citrix.task.translator.piglatin.rules.VowelRule;

/**
 * {@link PigLatinTranslator} translates a word into “pig-latin” using rules.
 */
public class PigLatinTranslator implements Translator {

    private final Rule rule;

    private PigLatinTranslator() {
        rule = new VowelRule().andThen(new ConsonantRule())
                              .andThen(new PunctuationRule())
                              .andThen(new CapitalizationRule());
    }

    /**
     * Translates a word into “pig-latin”
     * 
     * @param word to translate
     * @return translated “pig-latin” word
     */
    @Override
    public String translate(String word) {
        return rule.apply(word.trim(), word.trim());
    }

    public static Translator create() {
        return new HyphenAwareTranslator(new PigLatinTranslator());
    }
}
