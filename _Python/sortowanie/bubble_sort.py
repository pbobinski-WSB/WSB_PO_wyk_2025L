def bubble_sort(arr):
    n = len(arr)
    for j in range(n):
        for i in range(n - 1):
            if arr[i] > arr[i + 1]:
                arr[i], arr[i + 1] = arr[i + 1], arr[i]  # Zamiana miejscami
    return arr

# Przykład użycia
arr = [64, 34, 25, 12, 22, 11, 90]
sorted_arr = bubble_sort(arr)
print("Posortowana tablica:", sorted_arr)
