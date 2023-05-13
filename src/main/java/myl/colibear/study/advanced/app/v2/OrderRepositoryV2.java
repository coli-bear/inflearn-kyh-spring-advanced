package myl.colibear.study.advanced.app.v2;

import lombok.RequiredArgsConstructor;
import myl.colibear.study.advanced.trace.TraceId;
import myl.colibear.study.advanced.trace.TraceStatus;
import myl.colibear.study.advanced.trace.hellotrace.HelloTraceV2;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {
    private final HelloTraceV2 trace;

    public void saveOrder(TraceId traceId, String itemId) {
        TraceStatus status = null;
        try {
            status = this.trace.next(traceId, "OrderRepository.saveOrder()");
            if (itemId == null) {
                throw new IllegalArgumentException("NotNull!!!");
            }

            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생 !!");
            }

            this.sleep(1000);
            trace.end(status);
        } catch (Exception e) {
            this.trace.exception(status, e);
            throw e;
        }
    }

    private void sleep(int millis) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
