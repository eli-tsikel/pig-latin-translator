package com.citrix.task.translator.piglatin.rules;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VowelRuleTest {

    @Test
    public void testApply() {
        var rule = new VowelRule();
        var translated = rule.apply("apple", "apple");
        
        assertEquals("appleway", translated);
    }

    @Test
    public void testApply_notChanged() {
        var rule = new VowelRule();
        var translated = rule.apply("away", "away");
        
        assertEquals("away", translated);
    }
    
    @Test
    public void testApply_notChanged_withPunctuation() {
        var rule = new VowelRule();
        var translated = rule.apply("away.", "away.");
        
        assertEquals("away.", translated);
    }
    
    @Test
    public void testApply_withPunctuation() {
        var rule = new VowelRule();
        var translated = rule.apply("apple.", "apple.");
        
        assertEquals("apple.way", translated);
    }
}
