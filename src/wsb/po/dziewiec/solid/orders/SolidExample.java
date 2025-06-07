package wsb.po.dziewiec.solid.orders;

import java.util.*;

// Interfejs dla strategii płatności
interface Payable {
    void pay(double amount);
}

// Implementacja 1
class CreditCardPayment implements Payable {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " with credit card.");
    }
}

// Implementacja 2
class PayPalPayment implements Payable {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via PayPal.");
    }
}

// Klasa Produkt
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

// Klasa Order
class Order {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public double getTotal() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
}

// Serwis płatności (zasada D)
class OrderService {
    private final Payable payment;

    public OrderService(Payable payment) {
        this.payment = payment;
    }

    public void checkout(Order order) {
        double total = order.getTotal();
        payment.pay(total);
    }
}

// Main
public class SolidExample {
    public static void main(String[] args) {
        Order order = new Order();
        order.addProduct(new Product("Laptop", 2500));
        order.addProduct(new Product("Mouse", 150));

        Payable payment = new PayPalPayment(); // można łatwo podmienić strategię
        OrderService service = new OrderService(payment);
        service.checkout(order);
    }
}

/*
Zasady SOLID zastosowane:
S – pojedyncza odpowiedzialność (klasa Order tylko agreguje produkty)
O – otwarte na rozbudowę, zamknięte na modyfikację (strategia płatności)
L – zasada podstawiania Liskov (każda strategia płatności może zastąpić inną)
I – segregacja interfejsów (Payable nie wymaga implementacji nieużywanych metod)
D – wstrzykiwanie zależności (OrderService przyjmuje Payable jako zależność)
 */