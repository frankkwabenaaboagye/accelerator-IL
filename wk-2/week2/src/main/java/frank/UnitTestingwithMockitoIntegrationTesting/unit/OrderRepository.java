package frank.UnitTestingwithMockitoIntegrationTesting.unit;

/**
 * Repository interface for managing orders.
 */
public interface OrderRepository {
    /**
     * Saves the given order.
     *
     * @param order the order to be saved.
     * @return true if the order was successfully saved, false otherwise.
     */
    boolean save(Order order);
}