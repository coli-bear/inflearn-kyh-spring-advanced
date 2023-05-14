package myl.colibear.study.advanced.app.v3;

import lombok.RequiredArgsConstructor;
import myl.colibear.study.advanced.trace.TraceStatus;
import myl.colibear.study.advanced.trace.logtrace.FieldLogTrace;
import myl.colibear.study.advanced.trace.logtrace.LogTrace;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {
    private final OrderRepositoryV3 orderRepository;
    private final LogTrace fieldLogTrace;

    public void orderItem(String item) {
        TraceStatus status = null;
        try {
            status = this.fieldLogTrace.begin("OrderService.orderItem()");
            this.orderRepository.saveOrder(item);
            this.fieldLogTrace.end(status);
        } catch (Exception e) {
            this.fieldLogTrace.exception(status, e);
            throw e;
        }
    }
}
