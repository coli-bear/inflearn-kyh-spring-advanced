package myl.colibear.study.advanced.bean.annotation.inheritance;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@BusinessService("simBizSvc")
public class SimpleBusinessService {
    public void get() {
        log.info("{} is created and called by get method ", this.getClass().getCanonicalName());
    }
}
