package myl.colibear.study.advanced.sample.inheritance;

import myl.colibear.study.sample.inheritance.Parent;
import myl.colibear.study.sample.inheritance.Parent2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ParentTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void test() {
        assertThrows(NoUniqueBeanDefinitionException.class, () -> applicationContext.getBean(Parent.class));
    }

    @Test
    void test2() {
        assertDoesNotThrow(() -> applicationContext.getBean(Parent2.class));
    }

    @Test
    void test3() {
        assertThrows(NoSuchBeanDefinitionException.class, () -> applicationContext.getBean("parent"));
    }

    @Test
    void test4() {
        assertThrows(NoSuchBeanDefinitionException.class, () -> applicationContext.getBean("parent2"));
    }

    @Test
    void test5() {
        assertDoesNotThrow(() -> applicationContext.getBean("parent3"));
    }

    @Test
    void test6() {
        assertDoesNotThrow(() -> applicationContext.getBean("parent4"));
    }

}
