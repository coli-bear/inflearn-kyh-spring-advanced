package myl.colibear.study.advanced.trace.logtrace;

import myl.colibear.study.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class ThreadLogTraceTest {
    ThreadLogTrace threadLogTrace = new ThreadLogTrace();
    @Test
    public void begin_end_level2() {
        TraceStatus status1 = threadLogTrace.begin("hello1");
        TraceStatus status2 = threadLogTrace.begin("hello2");
        threadLogTrace.end(status2);
        threadLogTrace.end(status1);
    }

    @Test
    public void begin_exception_level2() {
        TraceStatus status1 = threadLogTrace.begin("hello1");
        TraceStatus status2 = threadLogTrace.begin("hello2");
        threadLogTrace.exception(status2, new IllegalStateException());
        threadLogTrace.exception(status1, new IllegalStateException());
    }
}