package wsb.po.trzy;

public class EqualsAndCompare {

    public static void main(String[] args) {

        int a = 5;
        int b = 5;
        int c = 3;

        System.out.println("a == b "+(a == b));
        System.out.println("a == c "+(a == c));
        System.out.println("a > b "+(a > b));
        System.out.println("a > c "+(a > c));

        String sa = new String("pięc");
        String sb = new String("pięc");
        String sc = new String("trzy");

        System.out.println("sa == sb "+(sa == sb));
        System.out.println("sa == sc "+(sa == sc));
   //   System.out.println("sa > sb "+(sa > sb));
   //   System.out.println("sa > sc "+(sa > sc));

        System.out.println("sa equals sb "+(sa.equals(sb)));
        System.out.println("sa equals sc "+(sa.equals(sc)));
        System.out.println("sa compareTo sb "+(sa.compareTo(sb)));
        System.out.println("sa compareTo sc "+(sa.compareTo(sc)));
        System.out.println("sc compareTo sa "+(sc.compareTo(sa)));


    }
}
