package wsb.po.piec.cashregister;

public class Exchange {

    private final static double rate = 4.2;
    public static double usd2pln (double amount) {
        return amount * rate;
    }
    public static double pln2usd (double amount) {
        return amount / rate;
    }
}
