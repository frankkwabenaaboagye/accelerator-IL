package frank.DesignPatterns.structural.facade;

public class Shipping {
    public void shipProduct(String productId, String customerId) {
        System.out.println("Shipping product ID " + productId + " to customer " + customerId);
    }
}