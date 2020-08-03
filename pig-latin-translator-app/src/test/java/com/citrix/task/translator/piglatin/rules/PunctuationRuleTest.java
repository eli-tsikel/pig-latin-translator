package com.citrix.task.translator.piglatin.rules;

import com.citrix.task.translator.piglatin.rules.PunctuationRule;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PunctuationRuleTest {

    @Test
    public void test() {
        PunctuationRule handler = new PunctuationRule();
        String converted = handler.apply("can't", "can'tway");
        
        assertEquals("cantwa'y", converted);
    }
}
