package myl.colibear.study.sample.scope;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SingletonScope {
    private static int singleScopeCreateCount = 0;
    public SingletonScope() {
        log.info("{} is created ({})", this.getClass().getCanonicalName(), ++singleScopeCreateCount);
    }
    @PostConstruct
    public void psstConstruct() {
        log.info("post construct");
    }
}
