package frank.sportsphere.service;

import frank.sportsphere.model.Order;
import frank.sportsphere.model.Product;
import frank.sportsphere.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;


    public Order placeOrder(Order order) {
        Product product = productService.getProductById(order.getProductId());
        if (order.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0.");
        }

        Order newOrder = Order.builder()
                .productId(product.getId())
                .quantity(order.getQuantity())
                .build();

        return orderRepository.save(newOrder);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(String id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found with ID: " + id));
    }

    public Order updateOrder(String id, Order updatedOrder) {
        return orderRepository.findById(id)
                .map(existingOrder -> {
                    if (updatedOrder.getQuantity() > 0) {
                        existingOrder.setQuantity(updatedOrder.getQuantity());
                    } else {
                        throw new IllegalArgumentException("Quantity must be greater than 0.");
                    }
                    return orderRepository.save(existingOrder);
                })
                .orElseThrow(() -> new IllegalArgumentException("Order not found with ID: " + id));
    }

    public void deleteOrder(String id) {
        if (!orderRepository.existsById(id)) {
            throw new IllegalArgumentException("Order not found with ID: " + id);
        }
        orderRepository.deleteById(id);
    }
}
