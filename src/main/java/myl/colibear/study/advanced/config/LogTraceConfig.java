package myl.colibear.study.advanced.config;

import myl.colibear.study.advanced.trace.logtrace.FieldLogTrace;
import myl.colibear.study.advanced.trace.logtrace.ThreadLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {
    @Bean
    public FieldLogTrace fieldLogTrace() {
        return new FieldLogTrace();
    }

    @Bean
    public ThreadLogTrace threadLogTrace() {
        return new ThreadLogTrace();
    }
}
