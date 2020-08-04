package com.citrix.task.translator.piglatin.rules;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CapitalizationRuleTest {

    @Test
    public void testApply() {
        var rule = new CapitalizationRule();
        var translated = rule.apply("McCloud", "tocitrix");
        
        assertEquals("ToCitrix", translated);
    }

}
