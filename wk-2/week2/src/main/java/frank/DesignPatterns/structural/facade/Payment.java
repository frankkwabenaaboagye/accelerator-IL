package frank.DesignPatterns.structural.facade;

public class Payment {
    public boolean processPayment(String customerId, double amount) {
        System.out.println("Processing payment of $" + amount + " for customer " + customerId);
        return true; // i am just assume payment succeeds
    }
}