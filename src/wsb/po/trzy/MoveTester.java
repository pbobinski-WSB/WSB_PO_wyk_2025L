package wsb.po.trzy;

import java.awt.*;

public class MoveTester {
    public static void main(String[] args) {
        Rectangle box = new Rectangle(5, 10, 20, 30);

        Rectangle box2 = box;

        // Move the rectangle
        box.translate(15, 25);

        // Print information about the moved rectangle
        System.out.print("x: ");
        System.out.println(box.getX());
        System.out.println("Expected: 20");

        System.out.print("y: ");
        System.out.println(box.getY());
        System.out.println("Expected: 35");

        System.out.println(box2);
    }
}