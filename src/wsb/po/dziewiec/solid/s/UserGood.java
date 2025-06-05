package wsb.po.dziewiec.solid.s;

// DOBRZE: Każda klasa ma jedną odpowiedzialność

// Klasa User - tylko dane użytkownika
class UserGood {
    private String name;
    private String email;

    public UserGood(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    // Można dodać settery jeśli potrzebne
}

// Klasa UserRepository - odpowiedzialna za operacje na bazie danych dotyczące użytkownika
class UserRepository {
    public void save(UserGood user) {
        System.out.println("Saving user " + user.getName() + " to database...");
        // Logika zapisu do bazy danych
    }
}

// Klasa EmailService - odpowiedzialna za wysyłanie emaili
class EmailService {
    public void sendWelcomeEmail(UserGood user) {
        System.out.println("Sending welcome email to " + user.getEmail() + "...");
        // Logika wysyłania emaila
    }
}

class SRPDemoGood {
    public static void main(String[] args) {
        UserGood user = new UserGood("Anna Nowak", "anna@example.com");
        UserRepository userRepo = new UserRepository();
        EmailService emailService = new EmailService();

        userRepo.save(user);
        emailService.sendWelcomeEmail(user);
    }
}
