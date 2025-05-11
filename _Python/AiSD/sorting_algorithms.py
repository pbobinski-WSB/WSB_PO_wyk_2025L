# --- a) Sortowanie Bąbelkowe (Bubble Sort) ---
def bubble_sort(data_list_orig):
    """Sortuje listę metodą bąbelkową.
    Złożoność czasowa: O(N^2) (pesymistyczna, średnia), O(N) (optymistyczna z flagą)
    Złożoność pamięciowa: O(1)
    Stabilność: Tak
    """
    data_list = list(data_list_orig) # Pracujemy na kopii
    n = len(data_list)
    for i in range(n - 1):
        swapped = False
        for j in range(n - 1 - i):
            if data_list[j] > data_list[j+1]:
                data_list[j], data_list[j+1] = data_list[j+1], data_list[j]
                swapped = True
        if not swapped:
            break
    return data_list

# --- b) Sortowanie przez Wstawianie (Insertion Sort) ---
def insertion_sort(data_list_orig):
    """Sortuje listę metodą przez wstawianie.
    Złożoność czasowa: O(N^2) (pesymistyczna, średnia), O(N) (optymistyczna)
    Złożoność pamięciowa: O(1)
    Stabilność: Tak
    """
    data_list = list(data_list_orig) # Pracujemy na kopii
    for i in range(1, len(data_list)):
        key_item = data_list[i]
        j = i - 1
        while j >= 0 and data_list[j] > key_item:
            data_list[j + 1] = data_list[j]
            j -= 1
        data_list[j + 1] = key_item
    return data_list

# --- c) Sortowanie przez Scalanie (Merge Sort) ---
def merge_sort(data_list_orig):
    """Sortuje listę metodą przez scalanie.
    Złożoność czasowa: O(N log N) (pesymistyczna, średnia, optymistyczna)
    Złożoność pamięciowa: O(N) (dla list pomocniczych)
    Stabilność: Tak
    """
    data_list = list(data_list_orig) # Zwracamy nową posortowaną listę
    if len(data_list) <= 1:
        return data_list

    mid = len(data_list) // 2
    left_half = data_list[:mid]
    right_half = data_list[mid:]

    left_sorted = merge_sort(left_half) # Rekurencyjnie sortujemy, nie modyfikujemy oryginału
    right_sorted = merge_sort(right_half)

    return _merge(left_sorted, right_sorted)

def _merge(left, right):
    """Funkcja pomocnicza do scalania dwóch posortowanych list."""
    merged_list = []
    i = 0
    j = 0
    while i < len(left) and j < len(right):
        if left[i] <= right[j]: # <= zapewnia stabilność
            merged_list.append(left[i])
            i += 1
        else:
            merged_list.append(right[j])
            j += 1
    merged_list.extend(left[i:])
    merged_list.extend(right[j:])
    return merged_list

# --- d) Sortowanie Szybkie (Quick Sort) ---
# Wersja tworząca nowe listy (prostsza, mniej wydajna pamięciowo)
def quick_sort_simple(data_list_orig):
    """Sortuje listę metodą szybką (wersja prostsza, tworząca nowe listy).
    Złożoność czasowa: O(N log N) (średnia), O(N^2) (pesymistyczna)
    Złożoność pamięciowa: O(N) (w pesymistycznym przypadku dla stosu i nowych list)
    Stabilność: Nie (w tej typowej implementacji)
    """
    data_list = list(data_list_orig) # Zwracamy nową posortowaną listę
    if len(data_list) <= 1:
        return data_list
    else:
        # Wybór pivota (np. środkowy element dla prostoty, można eksperymentować)
        # W tej wersji usuwamy pivot, aby uniknąć problemów z jego duplikatami,
        # co nie jest standardowe dla implementacji in-place.
        pivot_index = len(data_list) // 2
        pivot = data_list.pop(pivot_index) # Pobieramy i usuwamy pivot

        left = [x for x in data_list if x <= pivot] # Elementy równe pivotowi idą na lewo
        right = [x for x in data_list if x > pivot]

        return quick_sort_simple(left) + [pivot] + quick_sort_simple(right)

# Wersja "in-place" (bardziej klasyczna)
def quick_sort_inplace_wrapper(data_list_orig):
    """Sortuje listę metodą szybką (wersja "in-place").
    Złożoność czasowa: O(N log N) (średnia), O(N^2) (pesymistyczna)
    Złożoność pamięciowa: O(log N) (średnia, dla stosu rekurencji), O(N) (pesymistyczna)
    Stabilność: Nie
    """
    data_list = list(data_list_orig) # Modyfikujemy kopię
    _quick_sort_inplace_recursive(data_list, 0, len(data_list) - 1)
    return data_list

def _quick_sort_inplace_recursive(arr, low, high):
    if low < high:
        pi = _partition_inplace(arr, low, high)
        _quick_sort_inplace_recursive(arr, low, pi - 1)
        _quick_sort_inplace_recursive(arr, pi + 1, high)

def _partition_inplace(arr, low, high):
    # Wybór pivota (np. ostatni element)
    pivot_val = arr[high]
    i = low - 1 # Indeks mniejszego elementu

    for j in range(low, high):
        if arr[j] <= pivot_val: # <= zapewnia, że elementy równe pivotowi mogą iść na lewo
            i = i + 1
            arr[i], arr[j] = arr[j], arr[i]
    
    arr[i + 1], arr[high] = arr[high], arr[i + 1] # Umieść pivot na właściwym miejscu
    return i + 1


if __name__ == '__main__':
    import random
    import time

    print("Przykłady algorytmów sortowania (Część II, Sekcja 3)")
    
    # Przygotowanie danych testowych
    test_list_small = [5, 1, 4, 2, 8]
    test_list_medium = random.sample(range(1, 101), 20) # 20 losowych unikalnych liczb od 1 do 100
    test_list_large = random.choices(range(1, 1001), k=100) # 100 losowych liczb (mogą się powtarzać)

    algorithms = {
        "Bubble Sort": bubble_sort,
        "Insertion Sort": insertion_sort,
        "Merge Sort": merge_sort,
        "Quick Sort (Simple)": quick_sort_simple,
        "Quick Sort (In-place)": quick_sort_inplace_wrapper,
        "Python's sorted()": sorted # Dla porównania
    }

    print(f"\nTest na małej liście: {test_list_small}")
    for name, func in algorithms.items():
        sorted_l = func(test_list_small)
        print(f"  {name}: {sorted_l}")

    print(f"\nTest na średniej liście (pierwsze 10 elementów z {len(test_list_medium)}): {test_list_medium[:10]}...")
    for name, func in algorithms.items():
        start_time = time.perf_counter()
        sorted_l = func(test_list_medium)
        duration = time.perf_counter() - start_time
        # Sprawdzenie poprawności (proste)
        is_correct = all(sorted_l[i] <= sorted_l[i+1] for i in range(len(sorted_l)-1))
        print(f"  {name}: Poprawnie: {is_correct}, Czas: {duration:.6f}s, Wynik (pierwsze 10): {sorted_l[:10]}")

    print(f"\nTest na dużej liście (pierwsze 10 elementów z {len(test_list_large)}): {test_list_large[:10]}...")
    for name, func in algorithms.items():
        # Dla bardzo wolnych algorytmów na dużych listach można pominąć
        if name in ["Bubble Sort", "Insertion Sort"] and len(test_list_large) > 200: # Ograniczenie
             print(f"  {name}: Pominięto dla dużej listy.")
             continue

        start_time = time.perf_counter()
        sorted_l = func(test_list_large)
        duration = time.perf_counter() - start_time
        is_correct = all(sorted_l[i] <= sorted_l[i+1] for i in range(len(sorted_l)-1))
        print(f"  {name}: Poprawnie: {is_correct}, Czas: {duration:.6f}s, Wynik (pierwsze 10): {sorted_l[:10]}")

    # Demonstracja stabilności (lub jej braku)
    print("\nDemonstracja stabilności:")
    # Lista krotek (wartość, oryginalny_indeks)
    # Chcemy posortować po wartości, obserwując oryginalne indeksy dla równych wartości
    stability_test_data = [(3, 'a'), (1, 'b'), (4, 'c'), (1, 'd'), (5, 'e'), (9, 'f'), (2, 'g'), (6, 'h'), (5, 'i')]
    print(f"Dane wejściowe dla testu stabilności: {stability_test_data}")

    # Stabilne algorytmy powinny zachować kolejność (1,'b') przed (1,'d') oraz (5,'e') przed (5,'i')
    # Niestabilne mogą zamienić
    
    # Merge Sort (oczekiwany stabilny)
    merged_stable = merge_sort(stability_test_data) # Domyślnie sortuje po pierwszym elemencie krotki
    print(f"Merge Sort (stabilny?):         {merged_stable}")

    # Quick Sort In-place (oczekiwany niestabilny)
    # Aby quick_sort_inplace_wrapper działał na krotkach, _partition_inplace musi poprawnie je porównywać (domyślnie Python to robi)
    quick_inplace_stable = quick_sort_inplace_wrapper(stability_test_data)
    print(f"Quick Sort In-place (stabilny?): {quick_inplace_stable}")
    
    # Python's sorted() (gwarantowanie stabilny)
    python_sorted_stable = sorted(stability_test_data)
    print(f"Python's sorted() (stabilny?):   {python_sorted_stable}")

    # Dla Insertion Sort i Bubble Sort też można sprawdzić stabilność - powinny być stabilne
    insertion_stable = insertion_sort(stability_test_data)
    print(f"Insertion Sort (stabilny?):      {insertion_stable}")