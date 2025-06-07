# DOBRZE: Każda klasa ma jedną odpowiedzialność

class User:
    def __init__(self, name, email):
        self.name = name
        self.email = email

    def get_name(self):
        return self.name

    def get_email(self):
        return self.email

class UserRepository:
    def save(self, user: User):
        print(f"Saving user {user.get_name()} to database...")
        # Logika zapisu do bazy danych
        pass

class EmailService:
    def send_welcome_email(self, user: User):
        print(f"Sending welcome email to {user.get_email()}...")
        # Logika wysyłania emaila
        pass

# Użycie:
user = User("Anna Nowak", "anna@example.com")
user_repo = UserRepository()
email_service = EmailService()

user_repo.save(user)
email_service.send_welcome_email(user)