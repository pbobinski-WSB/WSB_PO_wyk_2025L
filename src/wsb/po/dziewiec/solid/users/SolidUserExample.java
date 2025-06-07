package wsb.po.dziewiec.solid.users;

import java.util.*;
// SRP: Pojedyncza odpowiedzialność
class User {
    private String username;
    private String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getEmail() { return email; }
    public String getUsername() { return username; }
}

// OCP + LSP: Interfejs walidatora
interface UserValidator {
    boolean isValid(User user);
}

// Implementacja walidatora e-mail
class EmailValidator implements UserValidator {
    public boolean isValid(User user) {
        return user.getEmail().contains("@");
    }
}

// ISP: Interfejs do logowania
interface Logger {
    void log(String message);
}

// Prosta implementacja loggera
class ConsoleLogger implements Logger {
    public void log(String message) {
        System.out.println("[INFO] " + message);
    }
}

// DIP: Serwis zależny od abstrakcji
class UserService {
    private final List<UserValidator> validators;
    private final Logger logger;

    public UserService(List<UserValidator> validators, Logger logger) {
        this.validators = validators;
        this.logger = logger;
    }

    public void register(User user) {
        for (UserValidator validator : validators) {
            if (!validator.isValid(user)) {
                logger.log("User registration failed: invalid data.");
                return;
            }
        }
        logger.log("User " + user.getUsername() + " registered successfully.");
    }
}

// Main
public class SolidUserExample {
    public static void main(String[] args) {
        User user = new User("john", "john@example.com");

        List<UserValidator> validators = List.of(new EmailValidator());
        Logger logger = new ConsoleLogger();

        UserService service = new UserService(validators, logger);
        service.register(user);
    }
}

/*
Główne założenia:
Każda klasa ma jedną odpowiedzialność (SRP)
Dodanie nowego typu walidacji nie wymaga modyfikowania istniejącego kodu (OCP)
Wszystkie implementacje walidatorów zachowują kontrakt interfejsu (LSP)
Interfejsy są małe i konkretne (ISP)
Serwis korzysta z wstrzykiwania zależności (DIP)
 */