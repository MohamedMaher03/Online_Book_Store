import models.Book;
import models.EBook;
import models.PaperBook;
import models.ShowcaseBook;

public class QuantumBookstoreFullTest {
    public static void main(String[] args) {
        QuantumBookstore store = new QuantumBookstore();

        Book b1 = new PaperBook("ISBN123", "Java Basics", "John Smith", 2020, 140.0, 5);
        Book b2 = new EBook("ISBN456", "Spring Boot", "Alice Brown", 2022, 90.0, "PDF");
        Book b3 = new ShowcaseBook("ISBN789", "History of Tech", "Mark Davis", 2005);

        store.addBook(b1);
        store.addBook(b2);
        store.addBook(b3);

        System.out.println("--- Removing outdated books ---");
        store.removeOutdatedBooks(10); // Removes b3

        System.out.println("--- Buying paper book ---");
        store.buyBook("ISBN123", 2, "test@example.com", "Cairo");

        System.out.println("--- Buying eBook ---");
        store.buyBook("ISBN456", 1, "user@email.com", "N/A");

        System.out.println("--- Attempt to buy Showcase book (should fail) ---");
        try {
            store.buyBook("ISBN789", 1, "x", "y");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
