package myl.colibear.study.advanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import myl.colibear.study.advanced.trace.strategy.code.strategy.ContextV2;
import myl.colibear.study.advanced.trace.strategy.code.strategy.StrategyLogin1;
import myl.colibear.study.advanced.trace.strategy.code.strategy.StrategyLogin2;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {
    /**
     * 전략 패턴 : 변하지 않는 부분을 Context 에 두고 Strategy interface 를 구현해서 사용
     *  -> 위임해서 처리한다.
     */
    @Test
    void contextStrategyV1() {
        ContextV2 c1 = new ContextV2();

        c1.execute(new StrategyLogin1());
        c1.execute(new StrategyLogin2());
    }
}
