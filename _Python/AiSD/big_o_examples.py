# --- Przykład 1: Wyszukiwanie elementu w liście/tablicy ---

def linear_search(data_list, target):
    """Wyszukuje target w data_list za pomocą przeszukiwania liniowego.
    Zwraca indeks elementu lub -1 jeśli nie znaleziono.
    Złożoność czasowa: O(N)
    Złożoność pamięciowa: O(1)
    """
    for i in range(len(data_list)):
        if data_list[i] == target:
            return i
    return -1

def binary_search(sorted_list, target):
    """Wyszukuje target w posortowanej sorted_list za pomocą wyszukiwania binarnego.
    Zwraca indeks elementu lub -1 jeśli nie znaleziono.
    Wymaga posortowanej listy!
    Złożoność czasowa: O(log N)
    Złożoność pamięciowa: O(1) (wersja iteracyjna)
    """
    low = 0
    high = len(sorted_list) - 1
    while low <= high:
        mid = (low + high) // 2
        if sorted_list[mid] == target:
            return mid
        elif sorted_list[mid] < target:
            low = mid + 1
        else: # sorted_list[mid] > target
            high = mid - 1
    return -1

# --- Przykład 2: Naiwne Potęgowanie ---

def naive_power(base, exp):
    """Oblicza base^exp przez wielokrotne mnożenie.
    Złożoność czasowa: O(exp)
    """
    if exp == 0: return 1
    if exp < 0: return 1 / naive_power(base, -exp)

    result = base
    for _ in range(exp - 1):
        result *= base
    return result

# --- Przykład 3: Szybkie Potęgowanie (Exponentiation by Squaring) ---

def fast_power_recursive(base, exp):
    """Oblicza base^exp za pomocą szybkiego potęgowania (rekurencyjnie).
    Złożoność czasowa: O(log exp)
    """
    if exp == 0: return 1
    if exp < 0: return 1 / fast_power_recursive(base, -exp)

    if exp % 2 == 0:
        half_power = fast_power_recursive(base, exp // 2)
        return half_power * half_power
    else:
        return base * fast_power_recursive(base, exp - 1)

def fast_power_iterative(base, exp_orig):
    """Oblicza base^exp za pomocą szybkiego potęgowania (iteracyjnie).
    Złożoność czasowa: O(log exp)
    """
    if exp_orig == 0: return 1
    if exp_orig < 0: return 1 / fast_power_iterative(base, -exp_orig)

    result = 1
    exp = exp_orig
    current_power_of_base = base

    while exp > 0:
        if exp % 2 == 1:
            result *= current_power_of_base
        current_power_of_base *= current_power_of_base
        exp //= 2
    return result

# --- Przykład 4: Znalezienie wszystkich par elementów w liście ---

def find_all_pairs(data_list):
    """Generuje wszystkie możliwe pary (element_i, element_j).
    Złożoność czasowa: O(N^2)
    Złożoność pamięciowa: O(N^2) (dla przechowywania par)
    """
    pairs = []
    for i in range(len(data_list)):
        for j in range(len(data_list)):
            pairs.append((data_list[i], data_list[j]))
    return pairs

def find_unique_ordered_pairs(data_list):
    """Generuje unikalne pary (element_i, element_j) gdzie i < j.
    Złożoność czasowa: O(N^2)
    Złożoność pamięciowa: O(N^2) (w najgorszym przypadku dla przechowywania par)
    """
    pairs = []
    n = len(data_list)
    for i in range(n):
        for j in range(i + 1, n):
            pairs.append((data_list[i], data_list[j]))
    return pairs

# --- Przykład 5: Rekurencyjne obliczanie N-tej liczby Fibonacciego ---

def fibonacci_recursive_naive(n):
    """Naiwne rekurencyjne obliczanie liczby Fibonacciego.
    Złożoność czasowa: O(2^N)
    Złożoność pamięciowa (stosu): O(N)
    """
    if n <= 0: return 0
    elif n == 1: return 1
    else:
        return fibonacci_recursive_naive(n-1) + fibonacci_recursive_naive(n-2)

# Rozwiązania O(N) dla Fibonacciego (dla porównania)
memo_fib = {}
def fib_memoization(n):
    """Fibonacci z memoizacją.
    Złożoność czasowa: O(N)
    Złożoność pamięciowa: O(N) (dla 'memo_fib' i stosu)
    """
    if n in memo_fib: return memo_fib[n]
    if n <= 0: return 0
    elif n == 1: return 1
    result = fib_memoization(n-1) + fib_memoization(n-2)
    memo_fib[n] = result
    return result

def fib_iterative(n):
    """Fibonacci iteracyjnie.
    Złożoność czasowa: O(N)
    Złożoność pamięciowa: O(1)
    """
    if n <= 0: return 0
    if n == 1: return 1
    a, b = 0, 1
    for _ in range(2, n + 1):
        a, b = b, a + b
    return b

if __name__ == '__main__':
    print("Przykłady algorytmów i ich złożoności (Część II, Sekcja 1)")

    # Testy dla wyszukiwania
    my_list = [1, 3, 5, 7, 9, 11, 13, 15]
    print(f"Linear search for 7 in {my_list}: index {linear_search(my_list, 7)}")
    print(f"Linear search for 8 in {my_list}: index {linear_search(my_list, 8)}")
    print(f"Binary search for 7 in {my_list}: index {binary_search(my_list, 7)}")
    print(f"Binary search for 8 in {my_list}: index {binary_search(my_list, 8)}")

    # Testy dla potęgowania
    print(f"Naive power 2^10: {naive_power(2, 10)}")
    print(f"Fast power (recursive) 2^10: {fast_power_recursive(2, 10)}")
    print(f"Fast power (iterative) 2^10: {fast_power_iterative(2, 10)}")
    # print(f"Naive power 2^20: {naive_power(2, 20)}") # Już widać różnicę
    # print(f"Fast power (iterative) 2^20: {fast_power_iterative(2, 20)}")

    # Testy dla par
    small_list = [1, 2, 3]
    print(f"All pairs for {small_list}: {find_all_pairs(small_list)}")
    print(f"Unique ordered pairs for {small_list}: {find_unique_ordered_pairs(small_list)}")

    # Testy dla Fibonacciego
    n_fib = 10
    print(f"Fibonacci naive({n_fib}): {fibonacci_recursive_naive(n_fib)}")
    memo_fib.clear() # Wyczyść memo przed ponownym użyciem
    print(f"Fibonacci memoization({n_fib}): {fib_memoization(n_fib)}")
    print(f"Fibonacci iterative({n_fib}): {fib_iterative(n_fib)}")

    # Pokazanie problemu z O(2^N)
    # n_fib_large = 30
    # print(f"Obliczanie Fibonacci naive({n_fib_large})... (może chwilę potrwać)")
    # start_time = time.time()
    # result_naive = fibonacci_recursive_naive(n_fib_large)
    # end_time = time.time()
    # print(f"Fibonacci naive({n_fib_large}): {result_naive} (czas: {end_time - start_time:.4f}s)")

    # start_time = time.time()
    # memo_fib.clear()
    # result_memo = fib_memoization(n_fib_large)
    # end_time = time.time()
    # print(f"Fibonacci memoization({n_fib_large}): {result_memo} (czas: {end_time - start_time:.4f}s)")