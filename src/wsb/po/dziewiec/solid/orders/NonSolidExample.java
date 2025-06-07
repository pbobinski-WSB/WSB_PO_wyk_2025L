package wsb.po.dziewiec.solid.orders;

import java.util.*;

class OrderManager {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public double getTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    public void pay(String type) {
        double total = getTotal();
        if (type.equals("card")) {
            System.out.println("Paid " + total + " with credit card.");
        } else if (type.equals("paypal")) {
            System.out.println("Paid " + total + " via PayPal.");
        } else {
            throw new UnsupportedOperationException("Payment type not supported");
        }
    }

    public void printReceipt() {
        System.out.println("Products: " + products.size());
    }
}

// Main
public class NonSolidExample {
    public static void main(String[] args) {
        OrderManager manager = new OrderManager();
        manager.addProduct(new Product("Laptop", 2500));
        manager.addProduct(new Product("Mouse", 150));
        manager.pay("paypal");
        manager.printReceipt();
    }
}

/*
Główne naruszenia:
Brak SRP: OrderManager robi wszystko (tworzenie, płatność, wypisywanie)
Brak OCP: dodanie nowego sposobu płatności wymaga edycji istniejącego kodu
Brak LSP: metody mogą rzucać UnsupportedOperationException
Brak ISP: klasa OrderManager zawiera metody niezwiązane z jej celem
Brak DIP: silne powiązania, brak wstrzykiwania zależności
 */