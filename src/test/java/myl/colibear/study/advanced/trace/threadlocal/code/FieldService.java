package myl.colibear.study.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldService {
    private String nameStore;
    public String logic (String name) {
        log.info("save name={} -> nameStore={}", name, nameStore);
        this.nameStore = name;
        sleep(1000L);
        log.info("search nameStore={}", this.nameStore);
        return this.nameStore;
    }

    private static void sleep(Long ms) {

        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
