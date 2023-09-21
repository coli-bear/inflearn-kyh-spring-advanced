package myl.colibear.study.advanced.bean.annotation.inheritance;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainService
public class SimpleDomainService {
    public void get() {
        log.info("{} is created and called by get method", this.getClass().getCanonicalName());
    }
}
