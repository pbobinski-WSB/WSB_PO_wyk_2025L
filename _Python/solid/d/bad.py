# ŹLE: Klasa łamie DIP
class EmailClient: # Moduł niskiego poziomu (konkretna implementacja)
    def send_email(self, recipient, subject, body):
        print(f"Sending email to {recipient} with subject '{subject}': {body}")

class NotificationService: # Moduł wysokiego poziomu
    def __init__(self):
        # Bezpośrednia zależność od konkretnej klasy EmailClient
        self.email_client = EmailClient() 

    def send_notification(self, user_email, message):
        # Ściśle powiązane z EmailClient
        self.email_client.send_email(user_email, "Notification", message)

# Użycie:
service = NotificationService()
service.send_notification("student@example.com", "Your grades are available.")