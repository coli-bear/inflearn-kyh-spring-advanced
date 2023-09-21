package myl.colibear.study.sample.lazy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("sample_eager")
public class SampleEager {
    private final static String canonicalName = SampleEager.class.getCanonicalName();

    public SampleEager() {
        log.info(canonicalName);
    }

    public void get() {
        log.info(canonicalName + ".get()");
    }
}
