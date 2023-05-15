package myl.colibear.study.advanced.app.v6;

import lombok.RequiredArgsConstructor;
import myl.colibear.study.advanced.trace.callback.TraceCallback;
import myl.colibear.study.advanced.trace.callback.TraceTemplate;
import myl.colibear.study.advanced.trace.logtrace.LogTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v6")
public class OrderControllerV6 {
    private final OrderServiceV6 orderService;
    private final TraceTemplate template;

    public OrderControllerV6(OrderServiceV6 orderService, LogTrace threadLogTrace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(threadLogTrace);
    }

    @GetMapping("/request")
    public String request(String itemId) {

        return template.execute("OrderController.request()", () -> orderService.orderItem(itemId));
    }
}
