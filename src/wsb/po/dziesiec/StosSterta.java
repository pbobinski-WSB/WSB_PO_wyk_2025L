package wsb.po.dziesiec;

/**
 * Ilustracja koncepcji stosu, sterty i umiejscowienia zmiennych.
 * @author kmi
 */
public class StosSterta {
    /**
     * Zmienna - na stercie, w obiekcie.
     */
    int a = 6;

    /**
     * Metoda obliczająca sumę atrybutu  i parametru.
     * @param b składnik sumy do policzenia, na stosie.
     * @return suma atrybutu  i parametru b, na stosie.
     */
    int obliczSumę(int b) {
        int suma = 0;
        suma = a + b;
        Integer i = 1;
        return suma;
    }

    /**
     * @param args argumenty programu, nieużywane.
     */
    public static void main(String[] args) {
        StosSterta ss = new StosSterta();
        int s = ss.obliczSumę(10);
        System.out.println("Suma: " + s);
    }

    void spin() {
        int i;
        for (i = 0; i < 100; i++) {
            ;// Loop body is empty
        }
    }

    void choice() {
        int j = 0;
        if (j < 20) {
            j++;
        }
    }
}
