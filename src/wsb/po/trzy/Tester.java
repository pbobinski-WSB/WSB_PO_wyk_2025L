package wsb.po.trzy;

public class Tester {

    public static void main(String[] args) {

        KlasaTestowa klasaTestowa = new KlasaTestowa();

        System.out.println("Test klasy testowej");
        System.out.println(klasaTestowa.getPole());

        KlasaTestowa klasaTestowa1 = new KlasaTestowa(10);
        System.out.println(klasaTestowa1.getPole());

        System.out.println(klasaTestowa1);

    }
}
