package myl.colibear.study.advanced.app.v6;

import lombok.RequiredArgsConstructor;
import myl.colibear.study.advanced.trace.callback.TraceTemplate;
import myl.colibear.study.advanced.trace.logtrace.LogTrace;
import myl.colibear.study.advanced.trace.logtrace.ThreadLogTrace;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV6 {
    private final OrderRepositoryV6 orderRepository;
    private final TraceTemplate traceTemplate;

    public OrderServiceV6(OrderRepositoryV6 orderRepository, ThreadLogTrace threadLogTrace) {
        this.orderRepository = orderRepository;
        this.traceTemplate = new TraceTemplate(threadLogTrace);
    }
    public String orderItem(String item) {
        return this.traceTemplate.execute("OrderService.orderItem()", () -> orderRepository.saveOrder(item));
    }
}
