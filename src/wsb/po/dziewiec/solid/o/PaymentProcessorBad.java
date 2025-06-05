package wsb.po.dziewiec.solid.o;

// ŹLE: Klasa łamie OCP
class PaymentProcessorBad {
    public void processPayment(double amount, String paymentType) {
        if (paymentType.equals("credit_card")) {
            System.out.println("Processing credit card payment of $" + amount);
            // Logika dla karty kredytowej
        } else if (paymentType.equals("paypal")) {
            System.out.println("Processing PayPal payment of $" + amount);
            // Logika dla PayPal
        } else if (paymentType.equals("blik")) { // Dodanie nowego typu płatności
            System.out.println("Processing BLIK payment of $" + amount);
            // Logika dla BLIK
        } else {
            throw new IllegalArgumentException("Unsupported payment type");
        }
    }

    public static void main(String[] args) {
        PaymentProcessorBad processor = new PaymentProcessorBad();
        processor.processPayment(100, "credit_card");
        processor.processPayment(50, "blik"); // Wymagało modyfikacji klasy PaymentProcessorBad
    }
}
