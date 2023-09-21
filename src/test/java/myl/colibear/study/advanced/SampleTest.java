package myl.colibear.study.advanced;

import myl.colibear.study.sample.Sample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotSame;

@SpringBootTest
class SampleTest {

    private static ApplicationContext applicationContext;

    @BeforeEach
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/applicationContext.xml");
    }

    @Test
    public void contextTest() {
        Sample sample = (Sample) applicationContext.getBean("sample");

        ApplicationContext newApplicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/applicationContext.xml");
        Sample newSample = (Sample) newApplicationContext.getBean("sample");

        assertNotSame(sample, newSample, "Same Sample instances");
    }
}