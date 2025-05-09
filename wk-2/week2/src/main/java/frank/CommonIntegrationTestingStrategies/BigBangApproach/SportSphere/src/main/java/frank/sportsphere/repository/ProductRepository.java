package frank.sportsphere.repository;

import frank.sportsphere.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
     Optional<Product> findProductById(String id);
}