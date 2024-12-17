package frank.structural.adapater.legacy;

public class LegacyPaymentProcessor {
    public void processPayment(String customerId, double amount) {
        System.out.println("Legacy System: Processed payment of $" + amount + " for Customer ID: " + customerId);
    }
}