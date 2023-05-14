package myl.colibear.study.advanced.app.v4;

import lombok.RequiredArgsConstructor;
import myl.colibear.study.advanced.trace.TraceStatus;
import myl.colibear.study.advanced.trace.logtrace.LogTrace;
import myl.colibear.study.advanced.trace.logtrace.ThreadLogTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v4")
@RequiredArgsConstructor
public class OrderControllerV4 {
    private final OrderServiceV4 orderService;
    private final LogTrace threadLogTrace;

    @GetMapping("/request")
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = threadLogTrace.begin("OrderController.request()");
            this.orderService.orderItem(itemId);
            threadLogTrace.end(status);
            return "ok";
        } catch (Exception e) {
            threadLogTrace.exception(status, e);
            throw e; // 예외를 꼭 던져줘야함.
        }
    }
}
