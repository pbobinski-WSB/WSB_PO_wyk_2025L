def insertion_sort(arr):
    n = len(arr)
    for j in range(1, n):
        x = arr[j]  # Klucz (element do wstawienia)
        i = j - 1

        # Przesuwanie większych elementów w prawo
        while i >= 0 and arr[i] > x:
            arr[i + 1] = arr[i]
            i -= 1
        
        arr[i + 1] = x  # Wstawienie klucza na właściwe miejsce

# Przykład użycia
arr = [64, 34, 25, 12, 22, 11, 90]
insertion_sort(arr)
print("Posortowana tablica:", arr)
