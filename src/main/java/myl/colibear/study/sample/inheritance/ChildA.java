package myl.colibear.study.sample.inheritance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("child_a")
public class ChildA extends Parent {
    @Override
    void get() {
        log.info(this.getClass().getCanonicalName());
    }
}
