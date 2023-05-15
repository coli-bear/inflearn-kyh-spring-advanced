package myl.colibear.study.advanced.app.v5;

import lombok.RequiredArgsConstructor;
import myl.colibear.study.advanced.trace.logtrace.LogTrace;
import myl.colibear.study.advanced.trace.template.AbstractTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v5")
@RequiredArgsConstructor
public class OrderControllerV5 {
    private final OrderServiceV5 orderService;
    private final LogTrace threadLogTrace;

    @GetMapping("/request")
    public String request(String itemId) {
        AbstractTemplate<String> template = new AbstractTemplate<String>(threadLogTrace) {
            @Override
            protected String call() {
                return orderService.orderItem(itemId);
            }
        };
        return template.execute("OrderController.request()");
    }
}
