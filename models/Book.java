package models;

public abstract class Book {
    protected String isbn;
    protected String title;
    protected String author;
    protected int year;
    protected double price;

    public Book(String isbn, String title, String author, int year, double price) {
        setIsbn(isbn);
        setTitle(title);
        setAuthor(author);
        setYear(year);
        setPrice(price);
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    protected void setIsbn(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN must not be empty");
        }
        this.isbn = isbn;
    }

    protected void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title must not be empty");
        }
        this.title = title;
    }

    protected void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author must not be empty");
        }
        this.author = author;
    }

    protected void setYear(int year) {
        if (year < 1500) {
            throw new IllegalArgumentException("Year must be valid (after 1500)");
        }
        this.year = year;
    }

    protected void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price must not be negative");
        }
        this.price = price;
    }

    public abstract boolean isAvailable();

    @Override
    public String toString() {
        return String.format("ISBN: %s, Title: %s, Author: %s, Year: %d, Price: %.2f",
                isbn, title, author, year, price);
    }
}
