package com.citrix.task.translator.piglatin.rules;

import com.citrix.task.translator.api.Rule;

import static com.citrix.task.translator.piglatin.rules.Utils.isVowel;
import static com.citrix.task.translator.piglatin.rules.Utils.removePunctuation;

/**
 * Words that start with a consonant have their first letter moved to the end of
 * the word and the letters “ay” added to the end.
 * 
 * Words that ends in “way” are not modified.
 * 
 * <pre>
 * Hello becomes Ellohay
 * </pre>
 */
public class ConsonantRule implements Rule {
    private static final String AY_SUFFIX = "ay";
    private static final String WAY_SUFFIX = "way";

    @Override
    public String apply(String originalWord, String translatedWord) {
        if (originalWord.isEmpty() || removePunctuation(translatedWord).endsWith(WAY_SUFFIX)) {
            return translatedWord;
        }

        if (!originalWord.equals(translatedWord)) {
            throw new IllegalStateException("In ConsonantRule, original and converted words must be the same. Original: " + originalWord + ". Converted: " + translatedWord);
        }

        return isApply(originalWord) ? new StringBuilder(originalWord).deleteCharAt(0)
                                                                      .append(Character.toLowerCase(originalWord.charAt(0)))
                                                                      .append(AY_SUFFIX)
                                                                      .toString()
                : originalWord;
    }

    private boolean isApply(String originalWord) {
        return !isVowel(originalWord.charAt(0)) && Character.isLetter(originalWord.charAt(0));
    }
}
