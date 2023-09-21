package myl.colibear.study.sample.inheritance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Child2 extends Parent2{
    @Override
    void get() {
        log.info(this.getClass().getCanonicalName());
    }
}
