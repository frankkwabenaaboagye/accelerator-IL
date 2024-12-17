package frank.structural.adapater.adapter;

import frank.structural.adapater.legacy.LegacyPaymentProcessor;
import frank.structural.adapater.modern.ModernPaymentAPI;

public class PaymentAdapter implements ModernPaymentAPI {
    private LegacyPaymentProcessor legacyProcessor;

    public PaymentAdapter(LegacyPaymentProcessor legacyProcessor) {
        this.legacyProcessor = legacyProcessor;
    }

    @Override
    public void pay(String accountNumber, double amount) {
        System.out.println("Adapter: Translating modern API request to legacy system...");

        String customerId = convertAccountToCustomerId(accountNumber);
        double paymentAmount = validateAndFormatAmount(amount);

        // Passing adapted data to the legacy processor
        legacyProcessor.processPayment(customerId, paymentAmount);
    }

    // Helper method to convert account number format - just for the demo
    private String convertAccountToCustomerId(String accountNumber) {
        // Simulate conversion logic (e.g., stripping "MODERN" prefix and formatting)
        if (accountNumber.startsWith("MODERN")) {
            return accountNumber.replace("MODERN", "LEGACY");
        }
        return "LEGACY_" + accountNumber;
    }

   // just for the demo
    private double validateAndFormatAmount(double amount) {
        if (amount <= 0) {
            System.out.println("Warning: Invalid amount! Defaulting to $1.00");
            return 1.00;
        }
        System.out.println("Adapter: Applying legacy system fee of $0.50...");
        return amount - 0.50;
    }
}