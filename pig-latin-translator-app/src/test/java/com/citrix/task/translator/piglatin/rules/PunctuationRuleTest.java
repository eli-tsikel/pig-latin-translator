package com.citrix.task.translator.piglatin.rules;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PunctuationRuleTest {

    @Test
    public void test() {
        var rule = new PunctuationRule();
        var translated = rule.apply("can't", "can'tway");
        
        assertEquals("cantwa'y", translated);
    }
}
