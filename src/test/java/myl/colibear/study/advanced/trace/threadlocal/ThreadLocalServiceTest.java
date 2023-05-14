package myl.colibear.study.advanced.trace.threadlocal;

import lombok.extern.slf4j.Slf4j;
import myl.colibear.study.advanced.trace.threadlocal.code.ThreadLocalService;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadLocalServiceTest {
    private ThreadLocalService threadLocalService = new ThreadLocalService();

    @Test
    void threadLocal() {
        log.info("main start");
        Runnable userA = () -> this.threadLocalService.logic("userA");
        Runnable userB = () -> this.threadLocalService.logic("userB");

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
//        this.sleep(1000L);
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
