package wsb.po.szesc.collections;

import java.util.HashSet;

public class CoinTest {

    public static void main(String[] args) {

        Coin coin1 = new Coin(2, "2 zeta");
        Coin coin2 = new Coin(2,"2 zeta");

        System.out.println(coin1 == coin2);
        System.out.println(coin1.equals(coin2));

        HashSet<Coin> zbior = new HashSet<>();
        zbior.add(coin1);
        zbior.add(coin2);
        System.out.println(zbior);
    }
}
