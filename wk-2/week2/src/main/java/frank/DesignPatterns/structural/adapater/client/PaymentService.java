package frank.DesignPatterns.structural.adapater.client;

import frank.DesignPatterns.structural.adapater.adapter.PaymentAdapter;
import frank.DesignPatterns.structural.adapater.modern.ModernPaymentAPI;
import frank.DesignPatterns.structural.adapater.legacy.LegacyPaymentProcessor;

public class PaymentService {

    public static void main(String[] args) {
        System.out.println("=== Legacy System Direct Usage ===");
        LegacyPaymentProcessor legacyProcessor = new LegacyPaymentProcessor();
        legacyProcessor.processPayment("LEGACY12345", 200.00);

        System.out.println("\n=== Modern System via Adapter ===");
        // Using the modern API with the adapter
        ModernPaymentAPI paymentAPI = new PaymentAdapter(legacyProcessor);
        paymentAPI.pay("MODERN12345", 200.00);

    }
}
