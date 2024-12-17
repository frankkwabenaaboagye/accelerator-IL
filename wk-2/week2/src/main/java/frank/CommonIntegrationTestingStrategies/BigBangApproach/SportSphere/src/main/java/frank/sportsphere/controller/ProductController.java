package frank.sportsphere.controller;

import frank.sportsphere.model.Product;
import frank.sportsphere.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    public Product addProduct(@RequestBody Product newProduct) {
        return productService.createProduct(newProduct);
    }

    @GetMapping("/read-all")
    public List<Product> getAllProducts() {
        return productService.readProducts();
    }

    @GetMapping("/read")
    public Product getProduct(@RequestParam String id) {
        return productService.getProductById(id);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestParam String id, @RequestBody Product updatedProduct) {
        return productService.updateProduct(id, updatedProduct);
    }

    @DeleteMapping("/delete")
    public void deleteProduct(@RequestParam String id) {
        productService.deleteProduct(id);
    }
}