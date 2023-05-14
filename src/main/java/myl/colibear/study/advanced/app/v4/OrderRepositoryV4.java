package myl.colibear.study.advanced.app.v4;

import lombok.RequiredArgsConstructor;
import myl.colibear.study.advanced.trace.TraceStatus;
import myl.colibear.study.advanced.trace.logtrace.LogTrace;
import myl.colibear.study.advanced.trace.logtrace.ThreadLogTrace;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {
    private final LogTrace threadLogTrace;

    public void saveOrder(String itemId) {
        TraceStatus status = null;
        try {
            status = this.threadLogTrace.begin("OrderRepository.saveOrder()");
            if (itemId == null) {
                throw new IllegalArgumentException("NotNull!!!");
            }

            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생 !!");
            }

            this.sleep(1000);
            this.threadLogTrace.end(status);
        } catch (Exception e) {
            this.threadLogTrace.exception(status, e);
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
