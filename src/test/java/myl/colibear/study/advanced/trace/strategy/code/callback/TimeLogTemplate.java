package myl.colibear.study.advanced.trace.strategy.code.callback;

import lombok.extern.slf4j.Slf4j;
import myl.colibear.study.advanced.trace.strategy.code.strategy.Strategy;

@Slf4j
public class TimeLogTemplate {
    public void execute(Callback callback) {
        long startTime = System.currentTimeMillis();

        // 비즈니스 로직 start
        callback.call();
        // 비즈니스 로직 end

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("result time = {}", resultTime);
    }
}
