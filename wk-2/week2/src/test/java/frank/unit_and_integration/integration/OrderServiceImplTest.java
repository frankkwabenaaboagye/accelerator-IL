package frank.unit_and_integration.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Integration test class for OrderServiceImpl with H2 in-memory database.
 */
@SpringBootTest(classes = PizzaOrderApplication.class)
class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        orderRepository.deleteAll();
    }

    @Test
    @Transactional
    public void testSaveOrder_ShouldPersistOrderInDatabase() {

        Order order = Order.builder()
                .pizzaName("Margherita")
                .size("Large")
                .build();

        Order savedOrder = orderService.saveOrder(order);

        System.out.println("Printing Order...");
        System.out.println(savedOrder.toString());

        assertNotNull(savedOrder.getId(), "Order ID should not be null after saving");

        Order retrievedOrder = orderRepository.findById(savedOrder.getId()).orElse(null);

        assertNotNull(retrievedOrder, "Order should exist in the database");
        assertEquals("Margherita", retrievedOrder.getPizzaName(), "Pizza name should match");
        assertEquals("Large", retrievedOrder.getSize(), "Pizza size should match");
    }
}