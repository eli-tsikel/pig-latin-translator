package com.citrix.task.translator;

import com.citrix.task.translator.piglatin.PigLatinTranslator;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;

/**
 * CLI application that reads text from cmd line and prints translated text to pig latin.
 */
public class CliApplication {

    public static void main(String[] args) throws IOException {
        TextTranslator translator = new TextTranslator(PigLatinTranslator.create());

        System.out.println("Enter text to translate to Pig Latin: ");
        StringWriter stringWriter = new StringWriter();
        translator.translate(new InputStreamReader(System.in), stringWriter);
        
        System.out.println("Translated result is: ");
        System.out.println(stringWriter);
    }
}
