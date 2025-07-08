package services;

public class ShippingService {
    public static void sendTo(String address, String title) {
        System.out.println("Quantum book store: Shipping \"" + title + "\" to address: " + address);
    }
}
