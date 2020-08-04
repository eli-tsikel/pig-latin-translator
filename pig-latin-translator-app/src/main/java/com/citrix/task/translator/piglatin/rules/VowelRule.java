package com.citrix.task.translator.piglatin.rules;

import com.citrix.task.translator.api.Rule;

import static com.citrix.task.translator.piglatin.rules.Utils.isVowel;
import static com.citrix.task.translator.piglatin.rules.Utils.removePunctuation;

/**
 *  Rule: Words that start with a vowel have the letters “way” added to the end. 
 *  <pre>
 *  apple becomes appleway
 *  </pre>
 * 
 *  Words that end in “way” are not modified.
 */
public class VowelRule implements Rule {
    private static final String WAY_SUFFIX = "way";

    @Override
    public String apply(String originalWord, String translatedWord) {
        if (originalWord.isEmpty() || removePunctuation(originalWord).endsWith(WAY_SUFFIX)) {
            return originalWord;
        }
        
        return isVowel(originalWord.charAt(0)) ? originalWord.concat(WAY_SUFFIX) : translatedWord;
    }
}
