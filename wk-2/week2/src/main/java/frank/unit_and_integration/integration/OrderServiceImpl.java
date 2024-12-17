package frank.unit_and_integration.integration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

/**
 * Service class responsible for managing pizza orders.
 */
@Service
@RequiredArgsConstructor
@ComponentScan("frank.unit_and_integration.integration")
public class OrderServiceImpl {
    private final OrderRepository orderRepository;

    /**
     * Saves a pizza order to the database.
     *
     * @param order the pizza order to be saved.
     * @return the saved order with the generated ID.
     */
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
}
