package myl.colibear.study.advanced.app.v1;

import lombok.RequiredArgsConstructor;
import myl.colibear.study.advanced.trace.TraceStatus;
import myl.colibear.study.advanced.trace.hellotrace.HelloTraceV1;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {
    private final HelloTraceV1 trace;

    public void saveOrder(String itemId) {
        // TODO 저장 로직

        TraceStatus status = null;
        try {
            status = this.trace.begin("OrderRepository.saveOrder()");
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
