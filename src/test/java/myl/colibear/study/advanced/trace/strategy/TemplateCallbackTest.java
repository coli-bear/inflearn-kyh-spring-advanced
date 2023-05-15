package myl.colibear.study.advanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import myl.colibear.study.advanced.trace.strategy.code.callback.TimeLogTemplate;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

    @Test
    void callBackV1() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(() -> log.info("비즈니스 로직 1 실행"));
        template.execute(() -> log.info("비즈니스 로직 2 실행"));
    }
}
