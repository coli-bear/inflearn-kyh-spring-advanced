package myl.colibear.study.sample.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SampleEventConsumer2 {
    @Order(0)
    @EventListener(classes = SampleEvent.class)
    public void consume() {
        log.info("this is order 1 sample event consumer");
    }
}
