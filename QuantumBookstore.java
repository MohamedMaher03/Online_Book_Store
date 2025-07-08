import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import models.Book;
import models.Emailable;
import models.Purchasable;
import models.Shippable;

public class QuantumBookstore {
    private List<Book> inventory = new ArrayList<>();

    public void addBook(Book book) {
        inventory.add(book);
        System.out.println("Quantum book store: Book added → " + book.getTitle());
    }

    public void removeOutdatedBooks(int olderThanYears) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        inventory.removeIf(book -> currentYear - book.getYear() > olderThanYears);
        System.out.println("Quantum book store: Removed books older than " + olderThanYears + " years.");
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        for (Book book : inventory) {
            if (book.getIsbn().equals(isbn)) {
                if (!book.isAvailable()) {
                    throw new RuntimeException("Quantum book store: This book is not for sale.");
                }

                Purchasable purchasable = (Purchasable) book;
                if (purchasable.getQuantity() < quantity) {
                    throw new RuntimeException("Quantum book store: Not enough stock.");
                }

                purchasable.reduceQuantity(quantity);
                double total = book.getPrice() * quantity;

                if (book instanceof Shippable) {
                    ((Shippable) book).ship(address);
                }
                if (book instanceof Emailable) {
                    ((Emailable) book).email(email);
                }

                System.out.println("Quantum book store: Purchase completed. Total paid: " + total);
                return total;
            }
        }
        throw new RuntimeException("Quantum book store: Book not found.");
    }
}
