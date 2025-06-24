class MojaKlasa:
    def __init__(self):
        self.publiczny = "To jest publiczne"
        self._chroniony = "To jest chronione (konwencja)"
        self.__prywatny = "To jest 'prywatne' (name mangling)"

    def metoda(self):
        print(self.__prywatny) # Dostęp wewnątrz klasy jest normalny

    def __inna_metoda(self):
        print("To jest 'prywatna' metoda")

class SubKlasa(MojaKlasa):
    def __init__(self):
        super().__init__()
        # Próba nadpisania __prywatny z MojaKlasa
        # W rzeczywistości tworzy nowy atrybut _SubKlasa__prywatny
        self.__prywatny = "To jest __prywatny w SubKlasa"

    def pokaz(self):
        print(self.__prywatny) # Odnosi się do _SubKlasa__prywatny
        # print(self.__prywatny_z_mojaklasa) # Błąd, nie ma takiego atrybutu bezpośrednio
        # print(self._MojaKlasa__prywatny) # Tak można się dostać (ale nie jest to zalecane)

# Tworzenie obiektów
obj_moja = MojaKlasa()
obj_sub = SubKlasa()

print(obj_moja.publiczny)
print(obj_moja._chroniony)

# Próba bezpośredniego dostępu do __prywatny z zewnątrz
# print(obj_moja.__prywatny) # To spowoduje AttributeError!

# Dostęp do "zniekształconej" nazwy (niezalecane, ale możliwe)
print(obj_moja._MojaKlasa__prywatny) # Wyświetli: To jest 'prywatne' (name mangling)
obj_moja._MojaKlasa__inna_metoda() # Wywoła metodę

obj_sub.metoda() # Wywoła metodę z MojaKlasa, która wyświetli oryginalną wartość _MojaKlasa__prywatny
obj_sub.pokaz() # Wyświetli: To jest __prywatny w SubKlasa