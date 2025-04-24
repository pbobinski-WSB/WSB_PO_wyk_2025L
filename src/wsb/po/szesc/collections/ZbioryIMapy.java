package wsb.po.szesc.collections;

import java.util.*;

public class ZbioryIMapy {

    public static void main(String[] args) {

        Set<String> zbiorH = new HashSet<>();
        Set<String> zbiorT = new TreeSet<>();

        zbiorH.add("dwa");
        zbiorT.add("dwa");
        zbiorH.add("pięć");
        zbiorT.add("pięć");
        zbiorH.add("osiem");
        zbiorT.add("osiem");
        zbiorH.add("wda");
        zbiorT.add("wda");
        zbiorH.add("trzy");
        zbiorT.add("trzy");

        System.out.println("HashSet");
        for (String s : zbiorH) {
            System.out.println(s);
            System.out.println(s.hashCode());
        }
        System.out.println("TreeSet");
        for (String s : zbiorT) {
            System.out.println(s);
        }

        Map<String, Double> mapaH = new HashMap<>();
        Map<String, Double> mapaT = new TreeMap<>();

        mapaH.put("jeden i dwa",1.2);
        mapaT.put("jeden i dwa",1.2);
        mapaH.put("dwa i trzy",2.3);
        mapaT.put("dwa i trzy",2.3);
        mapaH.put("sześć i pół",6.5);
        mapaT.put("sześć i pół",6.5);
        mapaH.put("jedenaście i pół",11.5);
        mapaT.put("jedenaście i pół",11.5);

        System.out.println("HashMap");
        for (String s : mapaH.keySet()) {
            System.out.println(mapaH.get(s));
            System.out.println(s.hashCode());
        }
        System.out.println("TreeMap");
        for (String s : mapaT.keySet()) {
            System.out.println(mapaT.get(s));
        }


    }

}
