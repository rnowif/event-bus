package com.rnowif.event;

import java.util.function.Consumer;

public interface EventRegistrar {
    <EVENT> void register(Class<EVENT> eventType, Consumer<EVENT> handler);
}
