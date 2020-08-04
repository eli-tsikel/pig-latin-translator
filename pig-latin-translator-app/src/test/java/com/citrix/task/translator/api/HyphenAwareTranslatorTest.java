package com.citrix.task.translator.api;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class HyphenAwareTranslatorTest {

    @Test
    public void testTranslate() {
        var translator = mock(Translator.class);
        
        var hyphenAwareTranslator = new HyphenAwareTranslator(translator);
        hyphenAwareTranslator.translate("this-bot");
        
        var wordCaptor = ArgumentCaptor.forClass(String.class);
        verify(translator, times(2)).translate(wordCaptor.capture());
        
        var wordsUT = wordCaptor.getAllValues().iterator();
        assertEquals("this", wordsUT.next());
        assertEquals("bot", wordsUT.next());
    }
    
    @Test
    public void testTranslate_noHyphen() {
        var translator = mock(Translator.class);
        
        var hyphenAwareTranslator = new HyphenAwareTranslator(translator);
        hyphenAwareTranslator.translate("thisbot");
        
        var wordCaptor = ArgumentCaptor.forClass(String.class);
        verify(translator).translate(wordCaptor.capture());
        
        assertEquals("thisbot", wordCaptor.getValue());
    }
    
    @Test
    public void testTranslate_emptyWord() {
        var translator = mock(Translator.class);
        
        var hyphenAwareTranslator = new HyphenAwareTranslator(translator);
        hyphenAwareTranslator.translate("");
        
        var wordCaptor = ArgumentCaptor.forClass(String.class);
        verify(translator).translate(wordCaptor.capture());
        
        assertEquals("", wordCaptor.getValue());
    }
}
