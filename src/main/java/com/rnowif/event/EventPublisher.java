package com.rnowif.event;

public interface EventPublisher {
    <EVENT> void publish(Class<EVENT> eventType, EVENT event);
}
