package models;

import services.ShippingService;

public class PaperBook extends Book implements Purchasable, Shippable {
    private int quantity;

    public PaperBook(String isbn, String title, String author, int year, double price, int quantity) {
        super(isbn, title, author, year, price);
        setQuantity(quantity);
    }

    @Override
    public boolean isAvailable() {
        return quantity > 0;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    protected void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must be 0 or more");
        }
        this.quantity = quantity;
    }

    @Override
    public void reduceQuantity(int amount) {
        if (amount > quantity) {
            throw new IllegalArgumentException("Not enough in stock to complete the purchase");
        }
        this.quantity -= amount;
    }

    @Override
    public void ship(String address) {
        System.out.printf("Quantum book store: Shipping \"%s\" to %s%n", this.title, address);
        ShippingService.sendTo(address, this.title);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Quantity: %d", quantity);
    }

}
