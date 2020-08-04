package com.citrix.task.translator.piglatin;

import com.citrix.task.translator.api.GenericTranslator;
import com.citrix.task.translator.api.HyphenAwareTranslator;
import com.citrix.task.translator.api.Translator;
import com.citrix.task.translator.piglatin.rules.CapitalizationRule;
import com.citrix.task.translator.piglatin.rules.ConsonantRule;
import com.citrix.task.translator.piglatin.rules.PunctuationRule;
import com.citrix.task.translator.piglatin.rules.VowelRule;

/**
 * Factory class to creates a translator according to pig latin rules.
 */
public final class PigLatinTranslatorFactory {

    private PigLatinTranslatorFactory() {
    }

    /**
     * Creates new instance of pig latin {@link Translator}
     * 
     * @return pig latin translator
     */
    public static Translator create() {
        var rule = new VowelRule().andThen(new ConsonantRule())
                                  .andThen(new PunctuationRule())
                                  .andThen(new CapitalizationRule());

        return new HyphenAwareTranslator(new GenericTranslator(rule));
    }
}
