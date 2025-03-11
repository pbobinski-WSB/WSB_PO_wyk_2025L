# Poniższy kod znajduje liczby pierwsze do określonej liczby n:

# funkcja (algorytm)
def znajdz_liczby_pierwsze(n):
    liczby_pierwsze = []
    for liczba in range(2, n + 1):
        for dzielnik in range(2, liczba):
            if liczba % dzielnik == 0:
                break
        else:
            liczby_pierwsze.append(liczba)
    return liczby_pierwsze

# wejście
n = int(input("Podaj liczbę: "))

# wyjście
print(znajdz_liczby_pierwsze(n))
