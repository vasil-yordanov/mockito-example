package com.comptel.hello;

public class MessageSupportFactory {
    private static MessageSupportFactory instance;
    private MessageRenderer renderer;
    private MessageProvider provider;

    private MessageSupportFactory() {
        provider = new HelloWorldMessageProvider();
        renderer = new StandardOutMessageRenderer();
    }

    static {
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance() {
        return instance;
    }

    public MessageRenderer getMessageRenderer() {
        return renderer;
    }

    public MessageProvider getMessageProvider() {
        return provider;
    }
}