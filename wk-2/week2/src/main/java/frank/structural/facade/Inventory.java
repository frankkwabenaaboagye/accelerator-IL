package frank.structural.facade;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> stock = new HashMap<>();

    public void addProduct(String productId, int quantity) {
        stock.put(productId, stock.getOrDefault(productId, 0) + quantity);
    }

    public boolean isAvailable(String productId) {
        return stock.getOrDefault(productId, 0) > 0;
    }

    public void reduceStock(String productId) {
        if (isAvailable(productId)) {
            stock.put(productId, stock.get(productId) - 1);
        }
    }
}