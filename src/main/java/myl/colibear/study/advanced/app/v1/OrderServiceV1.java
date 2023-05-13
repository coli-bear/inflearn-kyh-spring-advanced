package myl.colibear.study.advanced.app.v1;

import lombok.RequiredArgsConstructor;
import myl.colibear.study.advanced.trace.TraceStatus;
import myl.colibear.study.advanced.trace.hellotrace.HelloTraceV1;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {
    private final OrderRepositoryV1 orderRepository;
    private final HelloTraceV1 trace;

    public void orderItem(String item ) {
        TraceStatus status = null;
        try {
            status = this.trace.begin("OrderService.orderItem()");
            this.orderRepository.saveOrder(item);
            trace.end(status);
        } catch (Exception e) {
            this.trace.exception(status, e);
            throw e;
        }
    }
}
