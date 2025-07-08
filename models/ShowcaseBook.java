package models;

public class ShowcaseBook extends Book {
    public ShowcaseBook(String isbn, String title, String author, int year) {
        super(isbn, title, author, year, 0);
    }

    @Override
    public boolean isAvailable() {
        return false;
    }
}
