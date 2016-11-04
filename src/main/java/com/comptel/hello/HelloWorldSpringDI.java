package com.comptel.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldSpringDI {

    private ApplicationContext applicationContext;

    public HelloWorldSpringDI(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void main(){
        MessageRenderer mr = applicationContext.getBean("renderer", MessageRenderer.class);
        mr.render();
    }


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
        new HelloWorldSpringDI(applicationContext).main();
    }
}