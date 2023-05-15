package myl.colibear.study.advanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import myl.colibear.study.advanced.trace.strategy.code.strategy.ContextV1;
import myl.colibear.study.advanced.trace.strategy.code.strategy.Strategy;
import myl.colibear.study.advanced.trace.strategy.code.strategy.StrategyLogin1;
import myl.colibear.study.advanced.trace.strategy.code.strategy.StrategyLogin2;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {
    @Test
    void templateMethodV0() {
        this.login1();
        this.login2();
    }

    private void login1() {
        long startTime = System.currentTimeMillis();

        log.info("비즈니스로직 1 실행");

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("result time = {}", resultTime);
    }

    private void login2() {
        long startTime = System.currentTimeMillis();

        log.info("비즈니스로직 2 실행");

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("result time = {}", resultTime);
    }

    /**
     * 전략 패턴 : 변하지 않는 부분을 Context 에 두고 Strategy interface 를 구현해서 사용
     *  -> 위임해서 처리한다.
     */
    @Test
    void contextStrategyV1() {
        ContextV1 c1 = new ContextV1(new StrategyLogin1());
        ContextV1 c2 = new ContextV1(new StrategyLogin2());

        c1.execute();
        c2.execute();
    }

    @Test
    void contextStrategyV2() {
        // 익명 내부 클래스 사용
        ContextV1 c1 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("lambda 1");
            }
        });

        // 람다 사용
        ContextV1 c2 = new ContextV1(() -> log.info("lambda 2"));

        c1.execute();
        c2.execute();
    }
}
