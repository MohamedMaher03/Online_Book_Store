package models;

import services.MailService;

public class EBook extends Book implements Purchasable, Emailable {
    private String fileType;

    public EBook(String isbn, String title, String author, int year, double price, String fileType) {
        super(isbn, title, author, year, price);
        setFileType(fileType);
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    protected void setFileType(String fileType) {
        if (fileType == null || fileType.trim().isEmpty()) {
            throw new IllegalArgumentException("File type must not be empty");
        }
        this.fileType = fileType;
    }

    @Override
    public int getQuantity() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void reduceQuantity(int amount) {
        if (amount != 1) {
            throw new IllegalArgumentException("Quantum book store: EBooks can only be bought one at a time");
        }
    }

    @Override
    public void email(String recipient) {
        System.out.printf("Quantum book store: Sending eBook \"%s\" [%s] to %s%n", this.title, fileType, recipient);
        MailService.sendTo(recipient, this.title, fileType);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", File Type: %s", fileType);
    }
}
