# DOBRZE: Klasa stosuje OCP
from abc import ABC, abstractmethod

class PaymentStrategy(ABC): # Abstrakcja
    @abstractmethod
    def pay(self, amount):
        pass

class CreditCardPayment(PaymentStrategy):
    def pay(self, amount):
        print(f"Processing credit card payment of ${amount}")
        # Logika dla karty kredytowej

class PayPalPayment(PaymentStrategy):
    def pay(self, amount):
        print(f"Processing PayPal payment of ${amount}")
        # Logika dla PayPal

class BlikPayment(PaymentStrategy): # Nowa funkcjonalność - nowa klasa
    def pay(self, amount):
        print(f"Processing BLIK payment of ${amount}")
        # Logika dla BLIK

class PaymentProcessor:
    def process_payment(self, amount, payment_strategy: PaymentStrategy):
        payment_strategy.pay(amount)

# Użycie:
processor = PaymentProcessor()

credit_card_strategy = CreditCardPayment()
processor.process_payment(100, credit_card_strategy)

paypal_strategy = PayPalPayment()
processor.process_payment(75, paypal_strategy)

blik_strategy = BlikPayment() # Dodanie obsługi BLIK nie wymagało zmiany PaymentProcessor
processor.process_payment(50, blik_strategy)