# ŹLE: Klasa łamie SRP
class User:
    def __init__(self, name, email):
        self.name = name
        self.email = email

    def get_user_details(self):
        return f"Name: {self.name}, Email: {self.email}"

    def save_user_to_database(self):
        print(f"Saving user {self.name} to database...")
        # Logika zapisu do bazy danych
        pass

    def send_welcome_email(self):
        print(f"Sending welcome email to {self.email}...")
        # Logika wysyłania emaila
        pass

# Użycie:
user = User("Jan Kowalski", "jan@example.com")
print(user.get_user_details())
user.save_user_to_database()
user.send_welcome_email()