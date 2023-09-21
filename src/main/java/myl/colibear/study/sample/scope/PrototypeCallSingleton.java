package myl.colibear.study.sample.scope;

import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Scope("prototype")
public class PrototypeCallSingleton {

    private SingletonScope singletonScope;

    public PrototypeCallSingleton() {
        log.info("prototype called singleton scope");
    }

    @Autowired
    public void setSingletonScope(SingletonScope singletonScope) {
        log.info("set singleton scope : {}", singletonScope);
        this.singletonScope = singletonScope;
    }


    @PreDestroy
    public void destroy() {
        log.info("destroy");
    }
}
