package frank.UnitTestingwithMockitoIntegrationTesting.unit;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Class representing a pizza order.
 */
@Data
@AllArgsConstructor
public class Order {
    private String pizzaName;
    private String size;
}
