package com.citrix.task.translator.piglatin.rules;

import com.citrix.task.translator.api.Rule;

import static com.citrix.task.translator.piglatin.rules.Utils.isPunctuation;
import static com.citrix.task.translator.piglatin.rules.Utils.removePunctuation;

/**
 * Punctuation must remain in the same relative place from the end of the word.
 *
 * <pre>
 * can’t becomes antca’y 
 * end. becomes endway
 * </pre>
 *
 */
public class PunctuationRule implements Rule {

    @Override
    public String apply(String originalWord, String translatedWord) {
        if (originalWord.equals(translatedWord)) {
            return translatedWord;
        }

        StringBuilder resultBuilder = new StringBuilder(removePunctuation(translatedWord)).reverse();

        String reversedOriginalWord = new StringBuilder(originalWord).reverse()
                                                                     .toString();
        for (int i = 0; i < reversedOriginalWord.length(); i++) {
            if (isPunctuation(reversedOriginalWord.charAt(i))) {
                resultBuilder.insert(i, reversedOriginalWord.charAt(i));
            }
        }

        return resultBuilder.reverse()
                            .toString();
    }
}
