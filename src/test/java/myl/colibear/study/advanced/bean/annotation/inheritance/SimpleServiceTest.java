package myl.colibear.study.advanced.bean.annotation.inheritance;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class SimpleServiceTest {
    @Autowired
    private ApplicationContext ac;

    @Test
    void simpleServiceTest() {
        SimpleBusinessService simBizSvc = (SimpleBusinessService) this.ac.getBean("simBizSvc");
        assertNotNull(simBizSvc);
        simBizSvc.get();

        SimpleDomainService simpleDomainService = this.ac.getBean(SimpleDomainService.class);
        assertNotNull(simpleDomainService);
        simpleDomainService.get();
    }

    @Test
    void simpleServiceTest2() {
        SimpleAnnotationService bean = this.ac.getBean(SimpleAnnotationService.class);
        bean.get();
        assertNull(bean.getSimpleBusinessService());
    }
}