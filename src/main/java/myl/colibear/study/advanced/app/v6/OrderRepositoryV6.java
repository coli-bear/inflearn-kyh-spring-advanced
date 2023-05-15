package myl.colibear.study.advanced.app.v6;

import lombok.RequiredArgsConstructor;
import myl.colibear.study.advanced.trace.callback.TraceTemplate;
import myl.colibear.study.advanced.trace.logtrace.LogTrace;
import myl.colibear.study.advanced.trace.logtrace.ThreadLogTrace;
import myl.colibear.study.advanced.trace.template.AbstractTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV6 {
    private final TraceTemplate traceTemplate;

    public OrderRepositoryV6(ThreadLogTrace threadLogTrace) {
        this.traceTemplate = new TraceTemplate(threadLogTrace);
    }

    public String saveOrder(String itemId) {
        return traceTemplate.execute("OrderRepository.saveOrder()", () -> {
            if (itemId == null) {
                throw new IllegalArgumentException("NotNull!!!");
            }

            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생 !!");
            }

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return itemId;
        });
    }


}
