package hello.advanced.app.v4;

import hello.advanced.app.trace.logtrace.LogTrace;
import hello.advanced.app.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v4")
public class OrderControllerV4 {

    private final OrderServiceV4 orderService;
    private final LogTrace logTrace;

    @GetMapping("/request")
    public String request(String itemId) {
        AbstractTemplate<String> template = new AbstractTemplate<String>(logTrace) {
            @Override
            protected String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        };

        return template.execute("OrderController.request()");
    }
}
