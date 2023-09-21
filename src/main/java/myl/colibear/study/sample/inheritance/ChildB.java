package myl.colibear.study.sample.inheritance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("child_b")
public class ChildB extends Parent {
    @Override
    void get() {
        log.info(this.getClass().getCanonicalName());
    }
}
