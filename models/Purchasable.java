package models;

public interface Purchasable {
    int getQuantity();

    void reduceQuantity(int amount);
}
