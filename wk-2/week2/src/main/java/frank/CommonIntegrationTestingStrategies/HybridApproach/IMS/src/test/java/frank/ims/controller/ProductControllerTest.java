package frank.ims.controller;

import frank.ims.model.Product;
import frank.ims.service.real.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @MockitoBean
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void getAllProducts() throws Exception {

        when(productService.getAllProducts())
                .thenReturn(Arrays.asList(
                        new Product() {{ setId(1L); setName("Product A"); setPrice(100.0); setQuantity(10); }},
                        new Product() {{ setId(2L); setName("Product B"); setPrice(200.0); setQuantity(5); }}
                ));
        // Act: Perform GET request and capture the result
        MvcResult result = mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andReturn();

        // Extract and print the response body
        System.out.println("####################");
        String responseBody = result.getResponse().getContentAsString();
        System.out.println("The response is: " + responseBody);

        // Assert: Validate the response
        mockMvc.perform(get("/products"))
                .andExpect(jsonPath("$[0].name").value("Product A"))
                .andExpect(jsonPath("$[1].name").value("Product B"));

    }

}