package services;

public class MailService {
    public static void sendTo(String email, String title, String fileType) {
        System.out.println("Quantum book store: Sending \"" + title + "\" (" + fileType + ") to email: " + email);
    }
}