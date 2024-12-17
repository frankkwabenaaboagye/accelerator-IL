package frank.UnitTestingwithMockitoIntegrationTesting.integration;


import jakarta.persistence.*;
import lombok.*;

/**
 * JPA Entity class representing a pizza order.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pizza_order")
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pizzaName;
    private String size;

}