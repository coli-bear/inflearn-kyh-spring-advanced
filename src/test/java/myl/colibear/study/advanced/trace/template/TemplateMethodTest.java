package myl.colibear.study.advanced.trace.template;

import lombok.extern.slf4j.Slf4j;
import myl.colibear.study.advanced.trace.template.code.AbstractTemplate;
import myl.colibear.study.advanced.trace.template.code.SubClassLogic1;
import myl.colibear.study.advanced.trace.template.code.SubClassLogic2;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {
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
     * Template method 패턴 적용
     */
    @Test
    void templateMethodV1() {
        AbstractTemplate template1 = new SubClassLogic1();
        template1.execute();

        AbstractTemplate template2 = new SubClassLogic2();
        template2.execute();
    }

    @Test
    void templateMethodV2() {
        AbstractTemplate temp1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("temp1");
            }
        };

        temp1.execute();
        AbstractTemplate temp2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("temp2");
            }
        };

        temp2.execute();
    }

}
