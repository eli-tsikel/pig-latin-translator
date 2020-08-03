package com.citrix.task.translator.piglatin.rules;

import com.citrix.task.translator.api.Rule;
import com.citrix.task.translator.piglatin.rules.VowelRule;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VowelRuleTest {

    @Test
    public void testApply() {
        Rule rule = new VowelRule();
        String translated = rule.apply("apple", "apple");
        
        assertEquals("appleway", translated);
    }

    @Test
    public void testApply_notChanged() {
        Rule rule = new VowelRule();
        String translated = rule.apply("away", "away");
        
        assertEquals("away", translated);
    }
    
    @Test
    public void testApply_notChanged_withPunctuation() {
        Rule rule = new VowelRule();
        String translated = rule.apply("away.", "away.");
        
        assertEquals("away.", translated);
    }
    
    @Test
    public void testApply_withPunctuation() {
        Rule rule = new VowelRule();
        String translated = rule.apply("apple.", "apple.");
        
        assertEquals("apple.way", translated);
    }
}
