package com.spring.day_4.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

public class MyAvent extends ApplicationContextEvent {
    /**
     * Create a new ContextStartedEvent.
     *
     * @param source the {@code ApplicationContext} that the event is raised for
     * (must not be {@code null})
     */

    private String message;

    public String getMessage() {
        return message;
    }

    public MyAvent setMessage(String message) {
        this.message = message;
        return this;
    }

    public MyAvent(ApplicationContext source, String message) {
        super(source);
        this.message = message;

    }


}
