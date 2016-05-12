package com.rnowif.event.simple;

import com.rnowif.event.EventPublisher;
import com.rnowif.event.EventRegistrar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class SimpleEventBus implements EventPublisher, EventRegistrar {

    private final Map<Class, List<Consumer>> registeredHandlers;

    public SimpleEventBus() {
        registeredHandlers = new HashMap<>();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <EVENT> void publish(Class<EVENT> eventType, EVENT event) {
        registeredHandlers.getOrDefault(eventType, emptyList()).forEach(consumer -> consumer.accept(event));
    }

    @Override
    public <EVENT> void register(Class<EVENT> eventType, Consumer<EVENT> handler) {
        List<Consumer> handlers = registeredHandlers.getOrDefault(eventType, emptyList());
        handlers.add(handler);
        registeredHandlers.put(eventType, handlers);
    }

    private List<Consumer> emptyList() {
        return new ArrayList<>();
    }
}
