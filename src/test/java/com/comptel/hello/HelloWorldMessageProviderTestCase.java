package com.comptel.hello;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by cpt2vyo on 27.10.2016 г..
 */
public class HelloWorldMessageProviderTestCase {
    private HelloWorldMessageProvider messageProvider;

    @Before
    public void setUp(){
        messageProvider = new HelloWorldMessageProvider();
    }

    @Test
    public void testGetMessage(){
        String message = messageProvider.getMessage();
        Assert.assertEquals("The message is not the same", "Hello World!", message);
    }
}
