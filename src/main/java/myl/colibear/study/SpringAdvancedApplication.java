package myl.colibear.study;

import lombok.extern.slf4j.Slf4j;
import myl.colibear.study.sample.event.SampleEventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class SpringAdvancedApplication {

    @Autowired
    private SampleEventProducer sampleEventProducer;

    public static void main(String[] args) {
        SpringApplication.run(SpringAdvancedApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner () {
        log.info("====== [Start Event] ======");
        return (args) -> {
            sampleEventProducer.handle();
        };
    }

}
