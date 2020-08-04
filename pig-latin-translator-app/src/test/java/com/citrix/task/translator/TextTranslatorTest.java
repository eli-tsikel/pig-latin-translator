package com.citrix.task.translator;

import com.citrix.task.translator.piglatin.PigLatinTranslatorFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextTranslatorTest {

    private static final String TEST_FILE_NAME = "sample.txt";
    private static final String TEXT_UT = "Ellohay appleway. Stairway antca'y endway. Histay-hingtay isway  away Eachbay CcLoudmay; Ogay away.\nEwnay inelay.\n";

    @Test
    public final void testTranslateFromFile() throws IOException {
        var textTranslator = new TextTranslator(PigLatinTranslatorFactory.create());

        var inputStream = getClass().getClassLoader().getResourceAsStream(TEST_FILE_NAME);
        var stringWriter = new StringWriter();
        
        try (inputStream; stringWriter) {
            textTranslator.translate(new InputStreamReader(inputStream), stringWriter);
            
            assertEquals(TEXT_UT, stringWriter.toString());
        }
    }
}
