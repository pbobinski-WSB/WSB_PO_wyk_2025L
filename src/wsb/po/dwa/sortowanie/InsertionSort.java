package wsb.po.dwa.sortowanie;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int j = 1; j < n; j++) {
            int x = arr[j];  // Klucz (element do wstawienia)
            int i = j - 1;

            // Przesuwanie większych elementów w prawo
            while (i >= 0 && arr[i] > x) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = x;  // Wstawienie klucza na właściwe miejsce
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        insertionSort(arr);
        System.out.println("Posortowana tablica: " + Arrays.toString(arr));
    }
}
