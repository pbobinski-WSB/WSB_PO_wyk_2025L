package wsb.po.dziewiec.solid.d;

// DOBRZE: Stosowanie DIP

// Abstrakcja (interfejs)
interface MessageSender {
    void send(String recipient, String messageContent); // Uproszczony interfejs dla przykładu
}

// Moduł niskiego poziomu, zależy od abstrakcji
class EmailClientGood implements MessageSender {
    @Override
    public void send(String recipient, String messageContent) {
        // W bardziej złożonym przypadku messageContent mógłby być obiektem
        String subject = "Notification"; // Domyślny temat
        if (messageContent.contains("subject:")) { // Prosta logika do wyciągnięcia tematu
            subject = messageContent.substring(messageContent.indexOf("subject:") + 8, messageContent.indexOf("|body:")).trim();
            messageContent = messageContent.substring(messageContent.indexOf("|body:") + 6).trim();
        }
        System.out.println("Sending email to " + recipient + " with subject '" + subject + "': " + messageContent);
    }
}

// Inny moduł niskiego poziomu, zależy od abstrakcji
class SMSClientGood implements MessageSender {
    @Override
    public void send(String recipient, String messageContent) {
        if (messageContent.contains("subject:")) { // SMS nie ma tematu, usuwamy
            messageContent = messageContent.substring(messageContent.indexOf("|body:") + 6).trim();
        }
        System.out.println("Sending SMS to " + recipient + ": " + messageContent);
    }
}

// Moduł wysokiego poziomu, zależy od abstrakcji
class NotificationServiceGood {
    private MessageSender sender; // Zależność od interfejsu

    // Wstrzyknięcie zależności przez konstruktor
    public NotificationServiceGood(MessageSender sender) {
        this.sender = sender;
    }

    public void sendNotification(String userContact, String messageDetails) {
        this.sender.send(userContact, messageDetails);
    }
}

class DIPDemoGood {
    public static void main(String[] args) {
        // Możemy łatwo podmienić implementację
        MessageSender emailSender = new EmailClientGood();
        NotificationServiceGood notificationServiceEmail = new NotificationServiceGood(emailSender);
        notificationServiceEmail.sendNotification(
                "student@example.com",
                "subject: Grades Update |body: Your grades are available."
        );

        System.out.println("---");

        MessageSender smsSender = new SMSClientGood();
        NotificationServiceGood notificationServiceSms = new NotificationServiceGood(smsSender);
        notificationServiceSms.sendNotification(
                "+1234567890",
                "subject: Reminder |body: Quick reminder: project deadline tomorrow!"
        );
    }
}
