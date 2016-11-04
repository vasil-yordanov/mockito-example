package com.comptel.hello;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by cpt2vyo on 27.10.2016 г..
 */
public class HelloWorldSpringDITestCase {

    private ApplicationContext applicationContext;
    private HelloWorldSpringDI helloWolrdSpring;

    @Before
    public void setUp(){
        applicationContext = mock(ApplicationContext.class);
        helloWolrdSpring = new HelloWorldSpringDI(applicationContext);
    }

    @Test
    public void testMain(){
        MessageRenderer messageRenderer = mock(MessageRenderer.class);
        when(applicationContext.getBean("renderer",MessageRenderer.class)).thenReturn(messageRenderer);
        helloWolrdSpring.main();
        verify(messageRenderer).render();
    }
}
