package wsb.po.dziewiec.solid.d;

// ŹLE: Klasa łamie DIP

// Moduł niskiego poziomu (konkretna implementacja)
class EmailClientBad {
    public void sendEmail(String recipient, String subject, String body) {
        System.out.println("Sending email to " + recipient + " with subject '" + subject + "': " + body);
    }
}

// Moduł wysokiego poziomu
class NotificationServiceBad {
    private EmailClientBad emailClient; // Bezpośrednia zależność od konkretnej klasy EmailClientBad

    public NotificationServiceBad() {
        this.emailClient = new EmailClientBad(); // Tworzenie instancji wewnątrz
    }

    public void sendNotification(String userEmail, String message) {
        // Ściśle powiązane z EmailClientBad
        this.emailClient.sendEmail(userEmail, "Notification", message);
    }
}

class DIPDemoBad {
    public static void main(String[] args) {
        NotificationServiceBad service = new NotificationServiceBad();
        service.sendNotification("student@example.com", "Your grades are available.");
    }
}
