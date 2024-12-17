package frank.sportsphere.config;

import frank.sportsphere.model.Order;
import frank.sportsphere.model.Product;
import frank.sportsphere.repository.OrderRepository;
import frank.sportsphere.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

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

        Product product1 = Product.builder()
                .name("Football")
                .price(25.0)
                .description("A high-quality football")
                .build();

        Product product2 = Product.builder()
                .name("Basketball")
                .price(30.0)
                .description("A high-quality basketball")
                .build();

        Product product3 = Product.builder()
                .name("Tennis Racket")
                .price(50.0)
                .description("A professional tennis racket")
                .build();

        productRepository.saveAll(List.of(product1, product2, product3));

        Order order1 = Order.builder()
                .productId(product1.getId())
                .quantity(2)
                .build();

        Order order2 = Order.builder()
                .productId(product2.getId())
                .quantity(1)
                .build();

        orderRepository.saveAll(List.of(order1, order2));

        System.out.println("Database populated with sample data.");
    }
}