package myl.colibear.study.advanced.app.v3;

import lombok.RequiredArgsConstructor;
import myl.colibear.study.advanced.trace.TraceStatus;
import myl.colibear.study.advanced.trace.logtrace.LogTrace;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {
    private final LogTrace fieldLogTrace;
    public void saveOrder(String itemId) {
        TraceStatus status = null;
        try {
            status = this.fieldLogTrace.begin("OrderRepository.saveOrder()");
            if (itemId == null) {
                throw new IllegalArgumentException("NotNull!!!");
            }

            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생 !!");
            }

            this.sleep(1000);
            this.fieldLogTrace.end(status);
        } catch (Exception e) {
            this.fieldLogTrace.exception(status, e);
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
