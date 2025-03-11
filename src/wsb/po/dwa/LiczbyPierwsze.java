package wsb.po.dwa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class LiczbyPierwsze {
    public static List<Integer> znajdzLiczbyPierwsze(int n) {
        List<Integer> liczbyPierwsze = new ArrayList<>();
        for (int liczba = 2; liczba <= n; liczba++) {
            boolean jestPierwsza = true;
            for (int dzielnik = 2; dzielnik < liczba; dzielnik++) {
                if (liczba % dzielnik == 0) {
                    jestPierwsza = false;
                    break;
                }
            }
            if (jestPierwsza) {
                liczbyPierwsze.add(liczba);
            }
        }
        return liczbyPierwsze;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj liczbę: ");
        int n = scanner.nextInt();
        scanner.close();
        
        System.out.println(znajdzLiczbyPierwsze(n));
    }
}
