package frank.sportsphere.controller;

import frank.sportsphere.SportSphereApplication;
import frank.sportsphere.model.Product;
import frank.sportsphere.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = SportSphereApplication.class)
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    public void setup() {
        productRepository.deleteAll();
    }

    @Test
    public void testGetAllProducts() throws Exception {

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
        productRepository.saveAll(List.of(product1, product2));

        mockMvc.perform(MockMvcRequestBuilders.get("/products/read-all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Football"))
                .andExpect(jsonPath("$[1].name").value("Basketball"))
                .andExpect(jsonPath("$[0].price").value(25.0))
                .andExpect(jsonPath("$[1].price").value(30.0));
    }

    @Test
    public void testGetProductById() throws Exception {
        // Given
        Product product = Product.builder()
                .name("Football")
                .price(25.0)
                .description("A high-quality football")
                .build();
        Product savedProduct = productRepository.save(product);

        mockMvc.perform(MockMvcRequestBuilders.get("/products/read")
                        .param("id", savedProduct.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Football"))
                .andExpect(jsonPath("$.price").value(25.0));
    }
}