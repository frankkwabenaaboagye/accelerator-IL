package frank.ims.controller;

import frank.ims.model.Order;
import frank.ims.service.stub.StubOrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final StubOrderService orderService;

    public OrderController(StubOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        return orderService.processOrder(order);
    }
}