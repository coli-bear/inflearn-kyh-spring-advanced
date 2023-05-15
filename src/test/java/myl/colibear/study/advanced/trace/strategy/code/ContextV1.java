package myl.colibear.study.advanced.trace.strategy.code;

import lombok.extern.slf4j.Slf4j;

/**
 * 변하지 않는 컨택스트를 처리
 */
@Slf4j
public class ContextV1 {
    private final Strategy strategy;
    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        long startTime = System.currentTimeMillis();

        // 비즈니스 로직 start
        this.strategy.call();
        // 비즈니스 로직 end

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("result time = {}", resultTime);
    }
}
