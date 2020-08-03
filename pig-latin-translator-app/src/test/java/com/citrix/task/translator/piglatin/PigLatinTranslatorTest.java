package com.citrix.task.translator.piglatin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PigLatinTranslatorTest {

    private String[] testWords = new String[] { "Hello", "apple", "stairway", "stairway.", "can't", "end.", "this-thing", "Beach", "McCloud ", "" };
    private String[] convertedWords = new String[] { "Ellohay", "appleway", "stairway", "stairway.", "antca'y", "endway.", "histay-hingtay", "Eachbay", "CcLoudmay", "" };

    @Test
    public void testDefault() {
        assertEquals(testWords.length, convertedWords.length);

        for (int i = 0; i < testWords.length; i++) {
            String converted = PigLatinTranslator.create()
                                                 .translate(testWords[i]);

            assertEquals(convertedWords[i], converted);
        }
    }
}
