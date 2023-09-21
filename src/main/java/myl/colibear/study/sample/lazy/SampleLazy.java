package myl.colibear.study.sample.lazy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Slf4j
@Lazy
@Component("sample_lazy")
public class SampleLazy {
    private final static String canonicalName = SampleLazy.class.getCanonicalName();

    @Lazy
    public SampleLazy() {
        log.info(canonicalName);
    }

    public void get() {
        log.info(canonicalName + ".get()");
    }
}
