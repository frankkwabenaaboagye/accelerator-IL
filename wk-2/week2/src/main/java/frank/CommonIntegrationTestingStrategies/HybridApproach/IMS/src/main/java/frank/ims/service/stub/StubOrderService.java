package frank.ims.service.stub;

import frank.ims.model.Order;
import frank.ims.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class StubOrderService {
    private final OrderRepository orderRepository;

    public StubOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order processOrder(Order order) {
        // Simulate a payment stub
        order.setStatus("PENDING"); // Stubbed response
        return orderRepository.save(order);
    }
}