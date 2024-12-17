package frank.sportsphere.controller;

import frank.sportsphere.model.Product;
import frank.sportsphere.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product newProduct) {
        return productService.createProduct(newProduct);
    }

    @GetMapping("/read-all")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @GetMapping("/read")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@RequestParam String id) {
        return productService.getProductById(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct(@RequestParam String id, @RequestBody Product updatedProduct) {
        return productService.updateProduct(id, updatedProduct);
    }


    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@RequestParam String id) {
        productService.deleteProduct(id);
    }
}
