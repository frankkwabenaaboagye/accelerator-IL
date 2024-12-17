package frank.DesignPatterns.structural.facade;

public class FrankECommerceApp {
    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();

        orderFacade.displayCatalog();

        orderFacade.placeOrder("C001", "Customer123", 300000);
        orderFacade.placeOrder("B002", "Customer456", 25000);
        orderFacade.placeOrder("C002", "Customer789", 90000);


        orderFacade.checkProductAvailability("B002");
        orderFacade.placeOrder("B002", "Customer456", 25000); // Attempt to order again
        orderFacade.checkProductAvailability("B002");
    }
}
