package frank.sportsphere.config;

import frank.sportsphere.model.Order;
import frank.sportsphere.model.Product;
import frank.sportsphere.repository.OrderRepository;
import frank.sportsphere.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabasePopulator implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        populateDatabase();
    }

    public void populateDatabase() {

        productRepository.deleteAll();
        orderRepository.deleteAll();

        Product product1 = new Product();
        product1.setName("Football");
        product1.setPrice(25.0);
        product1.setDescription("A high-quality football");

        Product product2 = new Product();
        product2.setName("Basketball");
        product2.setPrice(30.0);
        product2.setDescription("A high-quality basketball");

        Product product3 = new Product();
        product3.setName("Tennis Racket");
        product3.setPrice(50.0);
        product3.setDescription("A professional tennis racket");

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        // Add some orders using the product IDs (assuming you have saved them and have the product IDs)
        Order order1 = new Order();
        order1.setProductId(product1.getId());
        order1.setQuantity(2);

        Order order2 = new Order();
        order2.setProductId(product2.getId());
        order2.setQuantity(1);

        orderRepository.save(order1);
        orderRepository.save(order2);

        System.out.println("Database populated with sample data.");
    }
}