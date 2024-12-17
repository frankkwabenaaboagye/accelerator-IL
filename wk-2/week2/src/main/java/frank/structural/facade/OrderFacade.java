package frank.structural.facade;

import java.util.HashMap;
import java.util.Map;

public class OrderFacade {
    private Inventory inventory = new Inventory();
    private Payment payment = new Payment();
    private Shipping shipping = new Shipping();

    // Sample products in the e-commerce
    private Map<String, Product> products = new HashMap<>();

    public OrderFacade() {
        Product car1 = new Product("C001", "Ferrari F8", "Car");
        Product car2 = new Product("C002", "Tesla Model S", "Car");
        Product bike1 = new Product("B001", "Yamaha YZF-R1", "Motorbike");
        Product bike2 = new Product("B002", "Ducati Panigale V4", "Motorbike");

        products.put(car1.getId(), car1);
        products.put(car2.getId(), car2);
        products.put(bike1.getId(), bike1);
        products.put(bike2.getId(), bike2);

        inventory.addProduct(car1.getId(), 5);
        inventory.addProduct(car2.getId(), 3);
        inventory.addProduct(bike1.getId(), 7);
        inventory.addProduct(bike2.getId(), 2);
    }

    public void placeOrder(String productId, String customerId, double paymentAmount) {
        System.out.println("\nPlacing order for Product ID: " + productId);

        if (!products.containsKey(productId)) {
            System.out.println("Product does not exist.");
            return;
        }

        if (!inventory.isAvailable(productId)) {
            System.out.println("Sorry, the product is out of stock.");
            return;
        }

        if (payment.processPayment(customerId, paymentAmount)) {
            inventory.reduceStock(productId);
            shipping.shipProduct(productId, customerId);
            System.out.println("Order placed successfully for " + products.get(productId));
        } else {
            System.out.println("Payment failed. Order could not be processed.");
        }
    }

    public void displayCatalog() {
        System.out.println("\n--- Product Catalog ---");
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }

    public void checkProductAvailability(String productId) {
        if (inventory.isAvailable(productId)) {
            System.out.println("Product ID " + productId + " is available.");
        } else {
            System.out.println("Product ID " + productId + " is out of stock.");
        }
    }
}