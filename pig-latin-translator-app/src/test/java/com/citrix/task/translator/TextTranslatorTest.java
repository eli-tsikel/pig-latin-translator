package com.citrix.task.translator;

import com.citrix.task.translator.piglatin.PigLatinTranslatorFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextTranslatorTest {

    private static final String TEXT_UT = "Ellohay appleway. Stairway antca'y endway. Histay-hingtay isway  away Eachbay CcLoudmay; Ogay away.\nEwnay inelay.\n";

    @Test
    public final void testTranslateFromFile() throws IOException {
        TextTranslator translator = new TextTranslator(PigLatinTranslatorFactory.create());

        try (
                InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.txt");
                StringWriter writer = new StringWriter()) {
            translator.translate(new InputStreamReader(inputStream), writer);
            
            assertEquals(TEXT_UT, writer.toString());
        }
    }
}
