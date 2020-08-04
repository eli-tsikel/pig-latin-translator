package com.citrix.task.translator.api;

/**
 * Generic immutable translator that applies rules on a single word
 */
public final class GenericTranslator implements Translator {
    private final Rule rule;
    
    public GenericTranslator(Rule rule) {
        this.rule = rule;
    }
    
    /**
     * Translates a word by appling translation rules
     * 
     * @param word to translate
     * @return translated word
     */
    @Override
    public String translate(String word) {
        return rule.apply(word.trim(), word.trim());
    }
}
