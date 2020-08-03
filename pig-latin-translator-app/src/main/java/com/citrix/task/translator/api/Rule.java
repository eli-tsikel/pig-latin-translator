package com.citrix.task.translator.api;

import java.util.Objects;

/**
 * A functional interface that applies single rule on a translated word. 
 * 
 * <p>Rules may be composed using {@link #andThen(Rule)} method.
 *
 */
@FunctionalInterface
public interface Rule {
    String apply(String originalWord, String translatedWord);

    /**
     * Returns a composed rule that first applies this rule to
     * its input, and then applies the {@code after} rule to the result.
     * 
     * @param after the rule to apply after this rule is applied
     * @return a composed rule that first applies this rule and then applies the {@code after} rule
     * 
     * @throws NullPointerException if after is null
     */
    default Rule andThen(Rule after) {
        Objects.requireNonNull(after);
        
        return (originalWord, translatedWord) -> after.apply(originalWord, this.apply(originalWord, translatedWord));
    }
}
