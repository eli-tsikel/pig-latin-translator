package com.citrix.task.translator.piglatin.rules;

import com.citrix.task.translator.api.Rule;

/**
 * The rule capitalizes letters at the same location as capitalized letters in the original word
 * 
 * <pre>
 * Beach becomes Eachbay
 * McCloud becomes CcLoudmay
 * </pre>
 */
public class CapitalizationRule implements Rule {

    @Override
    public String apply(String originalWord, String translatedWord) {
        StringBuilder stringBuilder = new StringBuilder(translatedWord.toLowerCase());
        
        for (int i = 0; i < originalWord.length(); i++) {
            char ch = originalWord.charAt(i);
            if (Character.isUpperCase(ch)) {
                stringBuilder.setCharAt(i, Character.toUpperCase(stringBuilder.charAt(i)));
            }
        }
        
        return stringBuilder.toString();
    }
}
