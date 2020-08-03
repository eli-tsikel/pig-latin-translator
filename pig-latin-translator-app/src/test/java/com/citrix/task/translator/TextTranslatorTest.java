package com.citrix.task.translator;

import com.citrix.task.translator.piglatin.PigLatinTranslator;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextTranslatorTest {

    private static final String textUT = "Ellohay appleway. Stairway antca'y endway. Histay-hingtay isway  away Eachbay CcLoudmay; Ogay away.\nEwnay inelay.\n";

    @Test
    public final void testTranslateText() throws IOException {
        TextTranslator translator = new TextTranslator(PigLatinTranslator.create());

        try (
                InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.txt");
                StringWriter writer = new StringWriter()) {
            translator.translate(new InputStreamReader(inputStream), writer);
            
            assertEquals(textUT, writer.toString());
        }
    }
}
