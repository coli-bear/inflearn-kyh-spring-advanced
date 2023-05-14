package myl.colibear.study.advanced.app.v3;

import lombok.RequiredArgsConstructor;
import myl.colibear.study.advanced.trace.TraceStatus;
import myl.colibear.study.advanced.trace.hellotrace.HelloTraceV2;
import myl.colibear.study.advanced.trace.logtrace.FieldLogTrace;
import myl.colibear.study.advanced.trace.logtrace.LogTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v3")
@RequiredArgsConstructor
public class OrderControllerV3 {
    private final OrderServiceV3 orderService;
    private final LogTrace fieldLogTrace;

    @GetMapping("/request")
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = fieldLogTrace.begin("OrderController.request()");
            this.orderService.orderItem(itemId);
            fieldLogTrace.end(status);
            return "ok";
        } catch (Exception e) {
            fieldLogTrace.exception(status, e);
            throw e; // 예외를 꼭 던져줘야함.
        }
    }
}
