package frank.unit_and_integration.integration;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository interface for handling order persistence.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}