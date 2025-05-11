# Problem: Znajdź największy element na liście [3, 1, 4, 2]
# Algorytm:
liczby = [3, 1, 4, 2]
if not liczby:
    print("Lista jest pusta")
else:
    najwieksza = liczby[0]  # Krok 1: Załóż, że pierwszy element jest największy
    if liczby[1] > najwieksza: # Krok 2: Porównaj z drugim
        najwieksza = liczby[1]
    if liczby[2] > najwieksza: # Krok 3: Porównaj z trzecim
        najwieksza = liczby[2]
    if liczby[3] > najwieksza: # Krok 4: Porównaj z czwartym
        najwieksza = liczby[3]
    print(f"Największa liczba to: {najwieksza}") # Krok 5: Wydrukuj wynik