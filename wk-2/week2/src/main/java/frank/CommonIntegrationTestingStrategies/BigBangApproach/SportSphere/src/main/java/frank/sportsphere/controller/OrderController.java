package frank.sportsphere.controller;

import frank.sportsphere.model.Order;
import frank.sportsphere.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Order placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }

    @GetMapping("/read-all")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/read")
    @ResponseStatus(HttpStatus.OK)
    public Order getOrderById(@RequestParam String id) {
        return orderService.getOrderById(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Order updateOrder(@RequestParam String id, @RequestBody Order updatedOrder) {
        return orderService.updateOrder(id, updatedOrder);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@RequestParam String id) {
        orderService.deleteOrder(id);
    }
}
