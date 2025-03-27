package wsb.po.cztery;

import java.util.*;


public class Listy {

    public static void main(String[] args) {

        List<Integer> ints = new ArrayList<>();

        List<Double> doubles = new ArrayList<>(Arrays.asList(1.2, 3.4, 6.7, 6.2, 7.8));

        List<String> strings = new ArrayList<>();

        String[] array = {"a", "b", "c", "d", "e"};
        List<String> list = new ArrayList<>(Arrays.asList(array));

        System.out.println(array.toString());
        System.out.println(list);


        ints.add(4);
        ints.add(9);
        ints.add(1);
        ints.add(9);
        ints.add(41);
/*
        doubles.add(2.4);
        doubles.add(5.4);
        doubles.add(8.1);
        doubles.add(1.4);
*/

        strings.add("napis 1");
        strings.add("napis 2");
        strings.add("napis 3");
        strings.add("napis 4");

        for (int i=0; i < ints.size(); i++) {
            System.out.println("ints od "+i+" = "+ints.get(i));
        }
        for (int i=0; i < doubles.size(); i++) {
            System.out.println("doulbes od "+i+" = "+ints.get(i));
        }
        for (int i=0; i < strings.size(); i++) {
            System.out.println("strings od "+i+" = "+strings.get(i));
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
