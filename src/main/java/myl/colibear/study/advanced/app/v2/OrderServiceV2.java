package myl.colibear.study.advanced.app.v2;

import lombok.RequiredArgsConstructor;
import myl.colibear.study.advanced.trace.TraceId;
import myl.colibear.study.advanced.trace.TraceStatus;
import myl.colibear.study.advanced.trace.hellotrace.HelloTraceV2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {
    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;

    public void orderItem(TraceId traceId, String item) {
        TraceStatus status = null;
        try {
            status = this.trace.next(traceId, "OrderService.orderItem()");
            this.orderRepository.saveOrder(status.getTraceId(), item);
            trace.end(status);
        } catch (Exception e) {
            this.trace.exception(status, e);
            throw e;
        }
    }
}
