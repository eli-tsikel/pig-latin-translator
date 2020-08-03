package com.citrix.task.translator.piglatin.rules;

import com.citrix.task.translator.api.Rule;
import com.citrix.task.translator.piglatin.rules.CapitalizationRule;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CapitalizationRuleTest {

    @Test
    public void testApply() {
        Rule rule = new CapitalizationRule();
        String translated = rule.apply("McCloud", "tocitrix");
        
        assertEquals("ToCitrix", translated);
    }

}
