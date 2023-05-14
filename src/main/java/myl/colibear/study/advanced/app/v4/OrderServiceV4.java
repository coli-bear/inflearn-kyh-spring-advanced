package myl.colibear.study.advanced.app.v4;

import lombok.RequiredArgsConstructor;
import myl.colibear.study.advanced.trace.TraceStatus;
import myl.colibear.study.advanced.trace.logtrace.LogTrace;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {
    private final OrderRepositoryV4 orderRepository;
    private final LogTrace threadLogTrace;

    public void orderItem(String item) {
        TraceStatus status = null;
        try {
            status = this.threadLogTrace.begin("OrderService.orderItem()");
            this.orderRepository.saveOrder(item);
            this.threadLogTrace.end(status);
        } catch (Exception e) {
            this.threadLogTrace.exception(status, e);
            throw e;
        }
    }
}
