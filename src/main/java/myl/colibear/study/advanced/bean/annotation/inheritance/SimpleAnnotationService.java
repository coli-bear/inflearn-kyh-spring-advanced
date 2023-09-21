package myl.colibear.study.advanced.bean.annotation.inheritance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@BusinessService
public class SimpleAnnotationService {
    private final SimpleService simpleBusinessService;

    public SimpleAnnotationService(@Autowired(required = false) SimpleService simpleBusinessService) {
        this.simpleBusinessService = simpleBusinessService;
    }

    public void get() {
        if (this.simpleBusinessService == null) {
            log.info("simple service is null");
        } else {
            log.info("simple service is not null");
        }
    }

    public SimpleService getSimpleBusinessService() {
        return simpleBusinessService;
    }
}
