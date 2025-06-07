package wsb.po.dziewiec.solid.users;

class UserManager {
    public void register(String username, String email) {
        if (!email.contains("@")) {
            System.out.println("Invalid email.");
            return;
        }

        if (username.length() < 3) {
            System.out.println("Username too short.");
            return;
        }

        System.out.println("User " + username + " registered.");
    }
}

// Main
public class NonSolidUserExample {
    public static void main(String[] args) {
        UserManager manager = new UserManager();
        manager.register("john", "john@example.com");
    }
}

/*
Naruszenia:
SRP: UserManager zajmuje się rejestracją, walidacją i logowaniem
OCP: dodanie nowej walidacji wymaga zmiany metody register
LSP: brak interfejsów, więc brak możliwości rozszerzeń bez ryzyka
ISP: niepotrzebnie rozbudowana klasa bez modularności
DIP: silne powiązanie z konkretnymi klasami (System.out, brak wstrzykiwania)
 */
