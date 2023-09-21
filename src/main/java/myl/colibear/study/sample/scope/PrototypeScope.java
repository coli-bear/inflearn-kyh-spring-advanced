package myl.colibear.study.sample.scope;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Scope("prototype")
public class PrototypeScope {
    private static int prototypeScopeCreateCount = 0;
    public PrototypeScope() {
        log.info("{} is created ({})", this.getClass().getCanonicalName(), ++prototypeScopeCreateCount);
    }
}
