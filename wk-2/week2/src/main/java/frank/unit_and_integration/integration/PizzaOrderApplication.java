package frank.unit_and_integration.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main class to start the Spring Boot application for managing pizza orders.
 */
@SpringBootApplication
public class PizzaOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzaOrderApplication.class, args);
    }
}
