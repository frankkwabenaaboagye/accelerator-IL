package frank.ims.service.real;

import frank.ims.model.Product;
import frank.ims.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.apache.tomcat.util.net.openssl.OpenSSLStatus.setName;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductServiceTest {

    private ProductService productService;
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
        // Mock the repository
        productRepository = Mockito.mock(ProductRepository.class);
        productService = new ProductService(productRepository);
    }

    @Test
    public void testGetAllProducts() {
        // Mock repository behavior
        Mockito.when(productRepository.findAll())
                .thenReturn(Arrays.asList(
                        new Product() {{ setId(1L); setName("Product A"); setPrice(100.0); setQuantity(10); }},
                        new Product() {{ setId(2L); setName("Product B"); setPrice(200.0); setQuantity(5); }}
                ));

        // Service call
        List<Product> products = productService.getAllProducts();

        // Assertions
        assertEquals(2, products.size());
        assertEquals("Product A", products.get(0).getName());
    }
}