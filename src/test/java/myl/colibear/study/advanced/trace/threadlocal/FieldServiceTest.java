package myl.colibear.study.advanced.trace.threadlocal;

import lombok.extern.slf4j.Slf4j;
import myl.colibear.study.advanced.trace.threadlocal.code.FieldService;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {
    private FieldService fieldService = new FieldService();

    @Test
    void field() {
        log.info("main start");
        Runnable userA = () -> this.fieldService.logic("userA");
        Runnable userB = () -> this.fieldService.logic("userB");

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
        this.sleep(10L);
        threadB.start();
        sleep(3000L);
        log.info("main end");
    }

    private void sleep(long l) {
        try {
            Thread.sleep(l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
