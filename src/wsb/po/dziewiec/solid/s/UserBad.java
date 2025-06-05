package wsb.po.dziewiec.solid.s;

// ŹLE: Klasa łamie SRP
class UserBad {
    private String name;
    private String email;

    public UserBad(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getUserDetails() {
        return "Name: " + this.name + ", Email: " + this.email;
    }

    public void saveUserToDatabase() {
        System.out.println("Saving user " + this.name + " to database...");
        // Logika zapisu do bazy danych
    }

    public void sendWelcomeEmail() {
        System.out.println("Sending welcome email to " + this.email + "...");
        // Logika wysyłania emaila
    }

    // Gettery i Settery dla name i email
    public String getName() { return name; }
    public String getEmail() { return email; }


    public static void main(String[] args) {
        UserBad user = new UserBad("Jan Kowalski", "jan@example.com");
        System.out.println(user.getUserDetails());
        user.saveUserToDatabase();
        user.sendWelcomeEmail();
    }
}