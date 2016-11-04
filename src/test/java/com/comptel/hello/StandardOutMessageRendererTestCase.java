package com.comptel.hello;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by cpt2vyo on 26.10.2016 г..
 */
public class StandardOutMessageRendererTestCase {
    private StandardOutMessageRenderer renderer;
    private MessageProvider messageProvider;

    @Before
    public void setUp(){
        renderer = new StandardOutMessageRenderer();
        messageProvider = mock(MessageProvider.class);
    }

    @Test(expected = RuntimeException.class)
    public void testRenderIfMessageProviderIsNotProvided(){
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        verifyNoMoreInteractions(out);
        renderer.render();

    }

    @Test
    public void testRenderIfMessageProviderIsProvided(){
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        String message = "Hi";
        when(messageProvider.getMessage()).thenReturn(message);
        renderer.setMessageProvider(messageProvider);
        renderer.render();
        verify(out).println(message);
    }

    @Test
    public void testSetGetMessageProvider(){
        renderer.setMessageProvider(messageProvider);
        MessageProvider actualMessageProvider = renderer.getMessageProvider();
        Assert.assertSame("MessageProvider is not the same", messageProvider, actualMessageProvider);
    }
}
