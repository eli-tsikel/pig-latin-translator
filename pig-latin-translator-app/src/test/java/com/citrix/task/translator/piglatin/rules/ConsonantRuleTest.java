package com.citrix.task.translator.piglatin.rules;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConsonantRuleTest {

    @Test
    public void testApply() {
        var rule = new ConsonantRule();
        var translated = rule.apply("Hello", "Hello");
        
        assertEquals("ellohay", translated);
    }
    
    @Test
    public void testApply_noConsonant() {
        var rule = new ConsonantRule();
        var translated = rule.apply("apple", "apple");
        
        assertEquals("apple", translated);
    }
    
    @Test
    public void testApply_notLatter() {
        var rule = new ConsonantRule();
        var translated = rule.apply("1apple", "1apple");
        
        assertEquals("1apple", translated);
    }

    @Test(expected = IllegalStateException.class)
    public void testApply_exception() {
        var rule = new ConsonantRule();
        rule.apply("Hello", "another");
    }
    
    @Test
    public void testApply_notChanged() {
        var rule = new ConsonantRule();
        var translated = rule.apply("stairway", "stairway");
        
        assertEquals("stairway", translated);
    }
    
    @Test
    public void testApply_notChanged_withPunctuation() {
        var rule = new ConsonantRule();
        var translated = rule.apply("stairway.", "stairway.");
        
        assertEquals("stairway.", translated);
    }
}
