package myl.colibear.study.sample.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class SampleEventProducer {
    private final ApplicationEventPublisher applicationEventPublisher;

    public SampleEventProducer(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void handle() {
        SampleEvent sample = new SampleEvent();
        applicationEventPublisher.publishEvent(sample);
    }
}
