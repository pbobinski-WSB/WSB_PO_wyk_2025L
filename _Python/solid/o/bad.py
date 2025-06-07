# ŹLE: Klasa łamie OCP
class PaymentProcessor:
    def process_payment(self, amount, payment_type):
        if payment_type == "credit_card":
            print(f"Processing credit card payment of ${amount}")
            # Logika dla karty kredytowej
        elif payment_type == "paypal":
            print(f"Processing PayPal payment of ${amount}")
            # Logika dla PayPal
        elif payment_type == "blik": # Dodanie nowego typu płatności
            print(f"Processing BLIK payment of ${amount}")
            # Logika dla BLIK
        else:
            raise ValueError("Unsupported payment type")

# Użycie:
processor = PaymentProcessor()
processor.process_payment(100, "credit_card")
processor.process_payment(50, "blik") # Wymagało modyfikacji klasy PaymentProcessor