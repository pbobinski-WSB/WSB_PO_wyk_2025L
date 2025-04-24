package wsb.po.szesc.collections;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Kolejki {

    public static void main(String[] args) {

        Queue<String> kolejka = new LinkedList<>();

        Stack<String> stos = new Stack<>();

        PriorityQueue<String> priorytet = new PriorityQueue<>();

        kolejka.add("raz");
        kolejka.add("dwa");
        kolejka.add("trzy");

        System.out.println("Kolejka FIFO");
        while (!kolejka.isEmpty()) {
            System.out.println(kolejka.remove());
        }

        stos.push("raz");
        stos.push("dwa");
        stos.push("trzy");

        System.out.println("Stos (kolejka LIFO)");
        while (!stos.isEmpty()) {
            System.out.println(stos.pop());
        }

        priorytet.add("raz");
        priorytet.add("dwa");
        priorytet.add("trzy");

        System.out.println("Kolejka priorytetowa");
        while (!priorytet.isEmpty()) {
            System.out.println(priorytet.remove());
        }

        PriorityQueue<Osoba> priorytetO = new PriorityQueue<>();

        priorytetO.add(new Osoba("raz",2));
        priorytetO.add(new Osoba("dwa",1));
        priorytetO.add(new Osoba("trzy",3));

        System.out.println("Kolejka priorytetowa Osoba");
        while (!priorytetO.isEmpty()) {
            System.out.println(priorytetO.remove());
        }


    }
}
