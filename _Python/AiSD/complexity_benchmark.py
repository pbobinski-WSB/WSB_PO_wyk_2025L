import time
import random
import math
import matplotlib.pyplot as plt
import numpy as np

# --- Definicje Algorytmów ---

# O(1) - Stała złożoność
def o1_constant_time(arr):
    """Zwraca pierwszy element listy (jeśli istnieje)."""
    if arr:
        return arr[0]
    return None

# O(log n) - Logarytmiczna złożoność
def o_log_n_binary_search(sorted_arr, target):
    """Wyszukiwanie binarne w posortowanej liście."""
    low = 0
    high = len(sorted_arr) - 1
    while low <= high:
        mid = (low + high) // 2
        if sorted_arr[mid] < target:
            low = mid + 1
        elif sorted_arr[mid] > target:
            high = mid - 1
        else:
            return mid
    return -1 # Nie znaleziono

# O(n) - Liniowa złożoność
def o_n_linear_sum(arr):
    """Sumuje wszystkie elementy listy."""
    total = 0
    for x in arr:
        total += x
    return total

# O(n log n) - Liniowo-logarytmiczna złożoność
def o_n_log_n_timsort(arr):
    """Sortowanie listy przy użyciu wbudowanego Timsort."""
    # Tworzymy kopię, aby nie modyfikować oryginalnej listy między testami
    # i aby pomiar obejmował operację sortowania
    return sorted(arr.copy())


# O(n^2) - Kwadratowa złożoność
def o_n_squared_bubble_sort(arr_to_sort):
    """Sortowanie bąbelkowe (naiwna implementacja)."""
    arr = arr_to_sort.copy() # Pracujemy na kopii
    n = len(arr)
    for i in range(n):
        swapped = False
        for j in range(0, n-i-1):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
                swapped = True
        if not swapped: # Optymalizacja: jeśli nie było zamian, lista jest posortowana
            break
    return arr

# O(2^n) - Wykładnicza złożoność
def o_2_power_n_fibonacci_recursive(n_val):
    """Naiwne rekurencyjne obliczanie liczby Fibonacciego."""
    if n_val <= 0:
        return 0
    elif n_val == 1:
        return 1
    else:
        return o_2_power_n_fibonacci_recursive(n_val-1) + o_2_power_n_fibonacci_recursive(n_val-2)

# --- Mechanizm Pomiaru Czasu ---

def measure_time(func, *args):
    """Mierzy czas wykonania funkcji."""
    start_time = time.perf_counter()
    func(*args)
    end_time = time.perf_counter()
    return end_time - start_time

# --- Główna część programu ---

if __name__ == "__main__":
    # Rozmiary danych wejściowych (N)
    # Dla większości algorytmów
    N_values_poly = [10, 50, 100, 200, 500, 1000, 2000, 5000, 10000]
    # Dla algorytmu O(2^n) użyjemy znacznie mniejszych N, bo rośnie bardzo szybko
    N_values_exp = [5, 10, 15, 20, 25, 28, 30, 32] # Już dla 30-35 będzie bardzo wolno

    # Przechowywanie wyników: { 'nazwa_algorytmu': [(N, czas), ...] }
    results = {
        "O(1)": [],
        "O(log n)": [],
        "O(n)": [],
        "O(n log n)": [],
        "O(n^2)": [],
        "O(2^n)": []
    }

    print("Rozpoczynam pomiary...")

    # Pomiary dla algorytmów wielomianowych i logarytmicznych
    for N in N_values_poly:
        print(f"  N = {N}")
        # Przygotowanie danych
        random_list = [random.randint(0, N * 10) for _ in range(N)]
        sorted_list = sorted(random_list) # Potrzebne dla binary search
        target_element = random.randint(0, N * 10) # Element do wyszukania

        # O(1)
        # Dla O(1) czas jest tak mały, że lepiej wykonać wiele razy i uśrednić,
        # ale dla uproszczenia demonstracji wykonamy raz.
        # W praktyce, na wykresie może być "zaszumiony" przez narzut interpretera.
        t = measure_time(o1_constant_time, random_list)
        results["O(1)"].append((N, t))

        # O(log n)
        if N > 0: # binary_search wymaga niepustej listy
            t = measure_time(o_log_n_binary_search, sorted_list, target_element)
            results["O(log n)"].append((N, t))
        else:
            results["O(log n)"].append((N, 0))


        # O(n)
        t = measure_time(o_n_linear_sum, random_list)
        results["O(n)"].append((N, t))

        # O(n log n)
        t = measure_time(o_n_log_n_timsort, random_list)
        results["O(n log n)"].append((N, t))

        # O(n^2) - Może być wolne dla dużych N, ograniczmy N dla tego testu
        if N <= 2000: # Ograniczenie, aby nie czekać zbyt długo
            t = measure_time(o_n_squared_bubble_sort, random_list)
            results["O(n^2)"].append((N, t))
        # else: # Można dodać placeholder, jeśli nie chcemy liczyć
        #     results["O(n^2)"].append((N, float('nan'))) # NaN jeśli nie liczono


    # Pomiary dla algorytmu O(2^n)
    print("\nRozpoczynam pomiary dla O(2^n)... (może to chwilę potrwać)")
    for N_exp in N_values_exp:
        print(f"  N (dla Fibonacciego) = {N_exp}")
        t = measure_time(o_2_power_n_fibonacci_recursive, N_exp)
        # mapujemy N_exp na "skalę" N_values_poly dla wykresu, to tylko przybliżenie
        # aby pokazać jak szybko rośnie w porównaniu, nie jest to idealne
        # Można też zrobić osobny wykres dla O(2^n)
        results["O(2^n)"].append((N_exp, t))

    print("\nPomiary zakończone.")

    # --- Generowanie Wykresów ---
    plt.figure(figsize=(12, 8))

    # Wykres dla złożoności wielomianowych i logarytmicznych
    for label, data in results.items():
        if label == "O(2^n)": # O(2^n) narysujemy osobno lub z inną skalą N
            continue
        if not data: continue # Pomiń, jeśli brak danych (np. dla dużych N w O(n^2))

        # Odfiltrujmy NaN jeśli istnieją (np. dla O(n^2) dla N > 2000)
        valid_data = [(n, t) for n, t in data if not math.isnan(t)]
        if not valid_data: continue

        n_vals = [item[0] for item in valid_data]
        times = [item[1] for item in valid_data]
        plt.plot(n_vals, times, marker='o', linestyle='-', label=label)

    plt.xlabel("Rozmiar danych wejściowych (N)")
    plt.ylabel("Czas wykonania (sekundy)")
    plt.title("Porównanie złożoności obliczeniowej algorytmów (bez O(2^n))")
    plt.legend()
    plt.grid(True)
    plt.yscale('log') # Skala logarytmiczna na osi Y może pomóc zobaczyć różnice
                      # dla szybko rosnących funkcji obok wolno rosnących.
                      # Można też użyć skali liniowej: plt.yscale('linear')
    plt.tight_layout()
    plt.savefig("complexity_comparison_poly.png")
    plt.show()


    # Osobny wykres dla O(2^n) ze względu na inną skalę N i czasu
    if results["O(2^n)"]:
        plt.figure(figsize=(10, 6))
        n_vals_exp = [item[0] for item in results["O(2^n)"]]
        times_exp = [item[1] for item in results["O(2^n)"]]

        plt.plot(n_vals_exp, times_exp, marker='o', linestyle='-', color='red', label="O(2^n) - Fibonacci")
        plt.xlabel("N (parametr dla Fibonacciego)")
        plt.ylabel("Czas wykonania (sekundy)")
        plt.title("Złożoność O(2^n) - Naiwny Fibonacci")
        plt.legend()
        plt.grid(True)
        # plt.yscale('log') # Tutaj skala logarytmiczna również może być użyteczna
        plt.tight_layout()
        plt.savefig("complexity_O_2_power_n.png")
        plt.show()

    # Można też spróbować narysować wszystko na jednym wykresie z logarytmiczną osią Y,
    # ale N dla Fibonacciego jest inne niż N dla pozostałych (długość listy).
    # Aby to sensownie porównać, trzeba by przyjąć pewne założenia lub
    # mocno ograniczyć zakres N dla pozostałych.
    # Poniżej próba, ale z zastrzeżeniem, że 'N' dla O(2^n) oznacza co innego.

    plt.figure(figsize=(12, 8))
    all_plot_data = []

    # Przygotowanie danych do wspólnego wykresu - NORMUJEMY "N" dla O(2^n)
    # To jest BARDZO SZTUCZNE dopasowanie, aby tylko pokazać krzywą.
    # Dla O(2^n) 'N' to parametr funkcji, nie rozmiar listy.
    # Weźmy N_values_exp jako 'N' dla O(2^n)
    if results["O(2^n)"]:
        n_vals_exp = [item[0] for item in results["O(2^n)"]]
        times_exp = [item[1] for item in results["O(2^n)"]]
        # Dodajemy tylko jeśli N jest małe, żeby nie zdominowało całkowicie
        #plt.plot(n_vals_exp, times_exp, marker='x', linestyle=':', color='magenta', label="O(2^n) (N dla Fibonacci)")

    # Reszta algorytmów
    for label, data in results.items():
        if not data: continue
        valid_data = [(n, t) for n, t in data if not math.isnan(t)]
        if not valid_data: continue
        n_vals = [item[0] for item in valid_data]
        times = [item[1] for item in valid_data]
        plt.plot(n_vals, times, marker='o', linestyle='-', label=f"{label} (N to rozmiar listy)")


    plt.xlabel("Rozmiar danych wejściowych (N)")
    plt.ylabel("Czas wykonania (sekundy) - Skala Logarytmiczna")
    plt.title("Porównanie złożoności obliczeniowej (WSZYSTKIE - OŚ Y LOG)")
    plt.legend(loc='upper right')
    plt.grid(True, which="both", ls="-") # Grid dla obu osi, także minor ticks
    plt.yscale('log')
    #plt.xscale('log') # Można też spróbować skali logarytmicznej na osi X
    plt.ylim(bottom=1e-7) # Ustawienie dolnej granicy, aby uniknąć problemów z log(0)
                         # i lepiej pokazać bardzo małe czasy
    plt.tight_layout()
    plt.savefig("complexity_comparison_all_log_y.png")
    plt.show()