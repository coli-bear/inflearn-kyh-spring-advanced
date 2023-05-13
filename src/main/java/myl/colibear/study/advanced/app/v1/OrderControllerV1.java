package myl.colibear.study.advanced.app.v1;

import lombok.RequiredArgsConstructor;
import myl.colibear.study.advanced.trace.TraceStatus;
import myl.colibear.study.advanced.trace.hellotrace.HelloTraceV1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class OrderControllerV1 {
    private final OrderServiceV1 orderService;
    private final HelloTraceV1 trace;

    @GetMapping("/request")
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = this.trace.begin("OrderControllerV1.request()");
            this.orderService.orderItem(itemId);
            this.trace.end(status);
            return "ok";
        } catch (Exception e) {
            this.trace.exception(status, e);
            throw e; // 예외를 꼭 던져줘야함.
        }
    }
}
