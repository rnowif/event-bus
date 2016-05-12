package com.rnowif.event.simple;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleEventBusTest {

    private class SampleEvent { }

    @Test
    public void should_publish_to_multiple_registered_event_consumers() {
        final List<SampleEvent> receivedEvents = new ArrayList<>();
        SimpleEventBus bus = new SimpleEventBus();

        bus.register(SampleEvent.class, receivedEvents::add);
        bus.register(SampleEvent.class, receivedEvents::add);

        SampleEvent sentEvent = new SampleEvent();
        bus.publish(SampleEvent.class, sentEvent);

        assertThat(receivedEvents).containsExactly(sentEvent, sentEvent);
    }

}