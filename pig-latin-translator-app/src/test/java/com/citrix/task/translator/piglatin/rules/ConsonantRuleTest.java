package com.citrix.task.translator.piglatin.rules;

import com.citrix.task.translator.api.Rule;
import com.citrix.task.translator.piglatin.rules.ConsonantRule;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConsonantRuleTest {

    @Test
    public void testApply() {
        Rule rule = new ConsonantRule();
        String translated = rule.apply("Hello", "Hello");
        
        assertEquals("ellohay", translated);
    }
    
    @Test
    public void testApply_noConsonant() {
        Rule rule = new ConsonantRule();
        String translated = rule.apply("apple", "apple");
        
        assertEquals("apple", translated);
    }
    
    @Test
    public void testApply_notLatter() {
        Rule rule = new ConsonantRule();
        String translated = rule.apply("1apple", "1apple");
        
        assertEquals("1apple", translated);
    }

    @Test(expected = IllegalStateException.class)
    public void testApply_exception() {
        Rule rule = new ConsonantRule();
        rule.apply("Hello", "another");
    }
    
    @Test
    public void testApply_notChanged() {
        Rule rule = new ConsonantRule();
        String translated = rule.apply("stairway", "stairway");
        
        assertEquals("stairway", translated);
    }
    
    @Test
    public void testApply_notChanged_withPunctuation() {
        Rule rule = new ConsonantRule();
        String translated = rule.apply("stairway.", "stairway.");
        
        assertEquals("stairway.", translated);
    }
}
