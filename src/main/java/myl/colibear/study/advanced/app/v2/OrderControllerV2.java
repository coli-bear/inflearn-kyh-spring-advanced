package myl.colibear.study.advanced.app.v2;

import lombok.RequiredArgsConstructor;
import myl.colibear.study.advanced.trace.TraceStatus;
import myl.colibear.study.advanced.trace.hellotrace.HelloTraceV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v2")
public class OrderControllerV2 {
    private final OrderServiceV2 orderService;
    private final HelloTraceV2 trace;

    @GetMapping("/request")
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = this.trace.begin("OrderControllerV1.request()");
            this.orderService.orderItem(status.getTraceId(), itemId);
            this.trace.end(status);
            return "ok";
        } catch (Exception e) {
            this.trace.exception(status, e);
            throw e; // 예외를 꼭 던져줘야함.
        }
    }
}
