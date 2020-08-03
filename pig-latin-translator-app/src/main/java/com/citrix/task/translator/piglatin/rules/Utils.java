package com.citrix.task.translator.piglatin.rules;

import java.util.regex.Pattern;

final class Utils {
    private static final String VOWELS = "aeiouAEIOU";
    private static final String PUNCTUATION_REGEX = "\\p{Punct}";
    
    private Utils() {
    }
    
    static boolean isVowel(char ch) {
        return VOWELS.indexOf(ch) != -1;
    }

    static String removePunctuation(String word) {
        return word.replaceAll(PUNCTUATION_REGEX, "");
    }

    static boolean isPunctuation(char ch) {
        return Pattern.matches(PUNCTUATION_REGEX, String.valueOf(ch));
    }    
}
