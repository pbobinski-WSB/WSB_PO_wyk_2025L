package wsb.po.cztery;

public class Tablice {

    public static void main(String[] args) {

        int [] ints = new int[10];

        double [] doubles = {1.2, 4.5, 6.7, 5.2, 9.3};

        String [] strings = new String[5];

        ints[0] = 4;
        ints[1] = 9;
        ints[2] = 1;
        ints[3] = 9;
        ints[4] = 41;

        strings[0] = "napis 1";
        strings[1] = "napis 2";
        strings[2] = "napis 3";
        strings[3] = "napis 4";

        for (int i=0; i < ints.length; i++) {
            System.out.println("ints od "+i+" = "+ints[i]);
        }
        for (int i=0; i < doubles.length; i++) {
            System.out.println("doulbes od "+i+" = "+ints[i]);
        }
        for (int i=0; i < strings.length; i++) {
            System.out.println("strings od "+i+" = "+strings[i]);
        }

        for (int i : ints) {
            System.out.println("ints "+i);
        }
        for (double d : doubles) {
            System.out.println("doubles "+d);
        }
        for (String s : strings) {
            System.out.println("strings "+s);
        }


    }

}
