package frank.sportsphere.controller;

import frank.sportsphere.SportSphereApplication;
import frank.sportsphere.model.Order;
import frank.sportsphere.model.Product;
import frank.sportsphere.repository.OrderRepository;
import frank.sportsphere.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = SportSphereApplication.class)
@AutoConfigureMockMvc
public class OrderControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @BeforeEach
    public void setup() {
        productRepository.deleteAll();
        orderRepository.deleteAll();
    }

    @Test
    public void testPlaceOrder() throws Exception {

        Product product = Product.builder()
                .name("Football")
                .price(25.0)
                .description("A high-quality football")
                .build();
        Product savedProduct = productRepository.save(product);

        Order order = Order.builder()
                .productId(savedProduct.getId())
                .quantity(2)
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/orders/create")
                        .contentType("application/json")
                        .content("{\"productId\": \"" + savedProduct.getId() + "\", \"quantity\": 2}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.productId").value(savedProduct.getId()))
                .andExpect(jsonPath("$.quantity").value(2));
    }

}