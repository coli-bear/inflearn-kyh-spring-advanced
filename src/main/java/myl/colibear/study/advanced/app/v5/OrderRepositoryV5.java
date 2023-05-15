package myl.colibear.study.advanced.app.v5;

import lombok.RequiredArgsConstructor;
import myl.colibear.study.advanced.trace.TraceStatus;
import myl.colibear.study.advanced.trace.logtrace.LogTrace;
import myl.colibear.study.advanced.trace.template.AbstractTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV5 {
    private final LogTrace threadLogTrace;
    public String saveOrder(String itemId) {
        AbstractTemplate<String> template = new AbstractTemplate<String>(threadLogTrace) {
            @Override
            protected String call() {
                if (itemId == null) {
                    throw new IllegalArgumentException("NotNull!!!");
                }

                if (itemId.equals("ex")) {
                    throw new IllegalStateException("예외 발생 !!");
                }

                this.sleep(1000);
                return itemId;
            }

            private void sleep(int millis) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        return template.execute("OrderRepositoryV5.saveOrder()");

    }


}
