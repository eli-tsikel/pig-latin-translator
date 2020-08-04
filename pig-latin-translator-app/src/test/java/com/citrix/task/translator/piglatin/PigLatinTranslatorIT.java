package com.citrix.task.translator.piglatin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PigLatinTranslatorIT {

    private static final String[] TEST_WORDS = new String[] { "Hello", "apple", "stairway", "stairway.", "can't", "end.", "this-thing", "Beach", "McCloud ", "" };
    private static final String[] WORDS_UT = new String[] { "Ellohay", "appleway", "stairway", "stairway.", "antca'y", "endway.", "histay-hingtay", "Eachbay", "CcLoudmay", "" };

    @Test
    public void testDefault() {
        assertEquals(TEST_WORDS.length, WORDS_UT.length);

        for (int i = 0; i < TEST_WORDS.length; i++) {
            var translated = PigLatinTranslatorFactory.create()
                                                      .translate(TEST_WORDS[i]);

            assertEquals(WORDS_UT[i], translated);
        }
    }
}
