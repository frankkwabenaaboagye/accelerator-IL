package frank.sportsphere.controller;

import frank.sportsphere.model.Order;
import frank.sportsphere.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    public Order placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }

    @GetMapping("/read-all")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/read")
    public Order getOrder(@RequestParam String id) {
        return orderService.getOrderById(id);
    }


    @PutMapping("/update")
    public Order updateOrder(@RequestParam String id, @RequestBody Order updatedOrder) {
        return orderService.updateOrder(id, updatedOrder);
    }

    @DeleteMapping("/delete")
    public void deleteOrder(@RequestParam String id) {
        orderService.deleteOrder(id);
    }
}
