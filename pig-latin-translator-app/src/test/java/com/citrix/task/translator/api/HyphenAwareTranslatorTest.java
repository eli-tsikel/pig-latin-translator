package com.citrix.task.translator.api;

import java.util.Iterator;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class HyphenAwareTranslatorTest {

    @Test
    public void testTranslate() {
        Translator translator = mock(Translator.class);
        
        HyphenAwareTranslator hyphenAwareTranslator = new HyphenAwareTranslator(translator);
        hyphenAwareTranslator.translate("this-bot");
        
        ArgumentCaptor<String> wordCaptor = ArgumentCaptor.forClass(String.class);
        verify(translator, times(2)).translate(wordCaptor.capture());
        
        Iterator<String> words = wordCaptor.getAllValues().iterator();
        assertEquals("this", words.next());
        assertEquals("bot", words.next());
    }
    
    @Test
    public void testTranslate_noHyphen() {
        Translator translator = mock(Translator.class);
        
        HyphenAwareTranslator hyphenAwareTranslator = new HyphenAwareTranslator(translator);
        hyphenAwareTranslator.translate("thisbot");
        
        ArgumentCaptor<String> wordCaptor = ArgumentCaptor.forClass(String.class);
        verify(translator).translate(wordCaptor.capture());
        
        assertEquals("thisbot", wordCaptor.getValue());
    }
    
    @Test
    public void testTranslate_emptyWord() {
        Translator translator = mock(Translator.class);
        
        HyphenAwareTranslator hyphenAwareTranslator = new HyphenAwareTranslator(translator);
        hyphenAwareTranslator.translate("");
        
        ArgumentCaptor<String> wordCaptor = ArgumentCaptor.forClass(String.class);
        verify(translator).translate(wordCaptor.capture());
        
        assertEquals("", wordCaptor.getValue());
    }
}
