package myl.colibear.study.advanced.app.v5;

import lombok.RequiredArgsConstructor;
import myl.colibear.study.advanced.trace.TraceStatus;
import myl.colibear.study.advanced.trace.logtrace.LogTrace;
import myl.colibear.study.advanced.trace.logtrace.ThreadLogTrace;
import myl.colibear.study.advanced.trace.template.AbstractTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV5 {
    private final OrderRepositoryV5 orderRepository;
    private final ThreadLogTrace trace;
    public String orderItem(String item) {
        AbstractTemplate<String> template = new AbstractTemplate<String>(trace) {
            @Override
            protected String call() {
                return orderRepository.saveOrder(item);
            }
        };

        return template.execute("OrderService.orderItem()");
    }
}
