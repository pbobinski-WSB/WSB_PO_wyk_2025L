package wsb.po.dziewiec.solid.o;

// DOBRZE: Klasa stosuje OCP

// Interfejs strategii płatności
interface PaymentStrategy {
    void pay(double amount);
}

// Konkretne implementacje strategii
class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        // Logika dla karty kredytowej
    }
}

class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        // Logika dla PayPal
    }
}

class BlikPayment implements PaymentStrategy { // Nowa funkcjonalność - nowa klasa
    @Override
    public void pay(double amount) {
        System.out.println("Processing BLIK payment of $" + amount);
        // Logika dla BLIK
    }
}

// Procesor płatności, który jest zamknięty na modyfikację, a otwarty na rozszerzenie
class PaymentProcessorGood {
    public void processPayment(double amount, PaymentStrategy paymentStrategy) {
        paymentStrategy.pay(amount);
    }
}

class OCPDemoGood {
    public static void main(String[] args) {
        PaymentProcessorGood processor = new PaymentProcessorGood();

        PaymentStrategy creditCardStrategy = new CreditCardPayment();
        processor.processPayment(100, creditCardStrategy);

        PaymentStrategy paypalStrategy = new PayPalPayment();
        processor.processPayment(75, paypalStrategy);

        PaymentStrategy blikStrategy = new BlikPayment(); // Dodanie obsługi BLIK nie wymagało zmiany PaymentProcessorGood
        processor.processPayment(50, blikStrategy);
    }
}
