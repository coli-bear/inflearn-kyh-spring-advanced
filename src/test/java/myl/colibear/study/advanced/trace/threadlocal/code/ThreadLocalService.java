package myl.colibear.study.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalService {

    /** 주의 !!!
     * 해당 ThreadLocal 을 모두 사용하고 나면 반드시 ThreadLocal#remove 를 호출하여 저장된 값을 제거해야 한다.
     * - 이유 :
     */
    private ThreadLocal<String> nameStore = new ThreadLocal<>();
    public String logic (String name) {
        log.info("save name={} -> nameStore={}", name, nameStore.get());
        this.nameStore.set(name);
        sleep(1000L);
        log.info("search nameStore={}", this.nameStore.get());
        return this.nameStore.get();
    }

    private static void sleep(Long ms) {

        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
