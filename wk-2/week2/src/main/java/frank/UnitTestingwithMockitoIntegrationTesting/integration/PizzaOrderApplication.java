package frank.UnitTestingwithMockitoIntegrationTesting.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class to start the Spring Boot application for managing pizza orders.
 */
@SpringBootApplication
public class PizzaOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzaOrderApplication.class, args);
    }
}
