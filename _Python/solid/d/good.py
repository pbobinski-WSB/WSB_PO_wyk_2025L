# DOBRZE: Stosowanie DIP
from abc import ABC, abstractmethod

class MessageSender(ABC): # Abstrakcja
    @abstractmethod
    def send(self, recipient, message_content):
        pass

class EmailClient(MessageSender): # Moduł niskiego poziomu, zależy od abstrakcji
    def send(self, recipient, message_content):
        subject = message_content.get("subject", "Notification")
        body = message_content.get("body", "")
        print(f"Sending email to {recipient} with subject '{subject}': {body}")

class SMSClient(MessageSender): # Inny moduł niskiego poziomu, zależy od abstrakcji
    def send(self, recipient, message_content):
        body = message_content.get("body", "")
        print(f"Sending SMS to {recipient}: {body}")

class NotificationService: # Moduł wysokiego poziomu, zależy od abstrakcji
    def __init__(self, sender: MessageSender): # Wstrzyknięcie zależności (abstraction)
        self.sender = sender

    def send_notification(self, user_contact, message_details):
        self.sender.send(user_contact, message_details)

# Użycie:
# Możemy łatwo podmienić implementację
email_sender = EmailClient()
notification_service_email = NotificationService(email_sender)
notification_service_email.send_notification(
    "student@example.com", 
    {"subject": "Grades Update", "body": "Your grades are available."}
)

sms_sender = SMSClient()
notification_service_sms = NotificationService(sms_sender)
notification_service_sms.send_notification(
    "+1234567890", 
    {"body": "Quick reminder: project deadline tomorrow!"}
)