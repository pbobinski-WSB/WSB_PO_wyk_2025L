package wsb.po.siedem.ser;

import java.io.*;
import java.util.concurrent.Callable;

public class TestSerializacji {

    public static void main(String[] args) {
        Coin coin = new Coin(1.2, "nazwa");
        System.out.println(coin);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("moneta.ser"));
            oos.writeObject(coin);
        } catch (IOException ex) {
            System.out.println(ex);
        }

        Coin moneta = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("moneta.ser"));
            moneta = (Coin) ois.readObject();
        } catch (Exception ex) {
            System.err.println(ex);
        }
        System.out.println(moneta);

    }
}
