package frank.UnitTestingwithMockitoIntegrationTesting.unit.test;

import frank.UnitTestingwithMockitoIntegrationTesting.unit.Order;
import frank.UnitTestingwithMockitoIntegrationTesting.unit.OrderRepository;
import frank.UnitTestingwithMockitoIntegrationTesting.unit.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    private OrderServiceImpl orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderServiceImpl(orderRepository);
    }

    @Test
    public void testSaveOrder_ShouldReturnTrue_WhenOrderIsSavedSuccessfully() {

        Order order = new Order("Margherita", "Large");

        when(orderRepository.save(order)).thenReturn(true);

        boolean result = orderService.saveOrder(order);

        verify(orderRepository).save(order);
        assertTrue(result);
    }

    @Test
    public void testSaveOrder_ShouldReturnFalse_WhenOrderSaveFails() {
        Order order = new Order("Pepperoni", "Medium");

        when(orderRepository.save(order)).thenReturn(false);

        boolean result = orderService.saveOrder(order);

        verify(orderRepository).save(order);
        assertFalse(result);
    }

}
