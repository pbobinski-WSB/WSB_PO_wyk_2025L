# part3_data_structures.py
import random

# --- 1. Tablice (Arrays) / Listy w Pythonie ---
print("--- 1. Tablice (Listy w Pythonie) ---")

# Pythonowe listy są dynamicznymi tablicami
my_list = [10, 20, 30, 40, 50]
print(f"Oryginalna lista: {my_list}")

# Dostęp do elementu po indeksie: O(1)
print(f"Element o indeksie 2: {my_list[2]}") # 30

# Długość listy: O(1)
print(f"Długość listy: {len(my_list)}")

# Dodawanie na końcu (amortyzowane O(1))
my_list.append(60)
print(f"Lista po append(60): {my_list}")

# Wstawianie w środku (O(N))
my_list.insert(1, 15) # Wstaw 15 na indeks 1
print(f"Lista po insert(1, 15): {my_list}") # [10, 15, 20, 30, 40, 50, 60]

# Usuwanie elementu (O(N) jeśli po wartości lub z środka, O(1) jeśli z końca przez pop())
removed_by_value = my_list.pop(3) # Usuń element o indeksie 3 (czyli 30)
print(f"Usunięto element {removed_by_value} z indeksu 3. Lista: {my_list}")
my_list.remove(40) # Usuń pierwszą napotkaną wartość 40
print(f"Lista po remove(40): {my_list}")

# Iteracja: O(N)
print("Iteracja po liście:")
for item in my_list:
    print(item, end=" ")
print("\n")


# --- 2. Tablice z Haszowaniem (Hash Tables / Słowniki w Pythonie) ---
print("--- 2. Tablice z Haszowaniem (Słowniki w Pythonie) ---")

# Słowniki w Pythonie są implementacją tablic z haszowaniem
my_dict = {"name": "Alice", "age": 30, "city": "New York"}
print(f"Oryginalny słownik: {my_dict}")

# Dodawanie/aktualizacja elementu (średnio O(1))
my_dict["occupation"] = "Engineer"
my_dict["age"] = 31 # Aktualizacja
print(f"Słownik po dodaniu/aktualizacji: {my_dict}")

# Dostęp do elementu po kluczu (średnio O(1))
print(f"Wiek: {my_dict['age']}")
print(f"Zawód (get): {my_dict.get('occupation')}")
print(f"Kraj (get z domyślną): {my_dict.get('country', 'N/A')}") # Bezpieczny dostęp

# Usuwanie elementu (średnio O(1))
removed_city = my_dict.pop("city")
print(f"Usunięto miasto: {removed_city}. Słownik: {my_dict}")

# Sprawdzanie przynależności klucza (średnio O(1))
print(f"Czy 'name' jest w słowniku? {'name' in my_dict}")
print(f"Czy 'city' jest w słowniku? {'city' in my_dict}")

# Iteracja po kluczach, wartościach, parach (klucz, wartość) - O(N)
print("Iteracja po kluczach:")
for key in my_dict: # lub my_dict.keys()
    print(key, end=" ")
print("\nIteracja po wartościach:")
for value in my_dict.values():
    print(value, end=" ")
print("\nIteracja po parach (klucz, wartość):")
for key, value in my_dict.items():
    print(f"({key}: {value})", end=" ")
print("\n")

# Przykład funkcji haszującej (bardzo uproszczony, tylko dla ilustracji)
# Wbudowana funkcja hash() w Pythonie jest znacznie bardziej zaawansowana
def simple_hash(key_str, table_size):
    hash_val = 0
    for char in key_str:
        hash_val = (hash_val * 31 + ord(char)) % table_size # Prosty wielomianowy hash
    return hash_val

print(f"Prosty hash dla 'name' (rozmiar tablicy 10): {simple_hash('name', 10)}")
print(f"Prosty hash dla 'age' (rozmiar tablicy 10): {simple_hash('age', 10)}")
print(f"Prosty hash dla 'mane' (rozmiar tablicy 10): {simple_hash('mane', 10)}") # Potencjalna kolizja z 'name'
print("\n")


# --- 3. Drzewa Binarne i Binarne Drzewa Poszukiwań (BST) ---
print("--- 3. Drzewa Binarne i Binarne Drzewa Poszukiwań (BST) ---")

class TreeNode:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None

    def __str__(self): # Do prostego wyświetlania wartości węzła
        return str(self.key)

class BinarySearchTree:
    def __init__(self):
        self.root = None

    def insert(self, key):
        if self.root is None:
            self.root = TreeNode(key)
        else:
            self._insert_recursive(self.root, key)

    def _insert_recursive(self, current_node, key):
        if key < current_node.key:
            if current_node.left is None:
                current_node.left = TreeNode(key)
            else:
                self._insert_recursive(current_node.left, key)
        elif key > current_node.key:
            if current_node.right is None:
                current_node.right = TreeNode(key)
            else:
                self._insert_recursive(current_node.right, key)
        # else: klucz już istnieje, można zignorować lub zaktualizować wartość (jeśli przechowujemy więcej niż klucz)

    def search(self, key):
        return self._search_recursive(self.root, key)

    def _search_recursive(self, current_node, key):
        if current_node is None or current_node.key == key:
            return current_node
        if key < current_node.key:
            return self._search_recursive(current_node.left, key)
        else: # key > current_node.key
            return self._search_recursive(current_node.right, key)

    # Metody przechodzenia drzewa
    def inorder_traversal(self, node, result_list):
        # LVR (Lewy, Węzeł, Prawy) - dla BST daje posortowane elementy
        if node:
            self.inorder_traversal(node.left, result_list)
            result_list.append(node.key)
            self.inorder_traversal(node.right, result_list)

    def preorder_traversal(self, node, result_list):
        # VLR (Węzeł, Lewy, Prawy)
        if node:
            result_list.append(node.key)
            self.preorder_traversal(node.left, result_list)
            self.preorder_traversal(node.right, result_list)

    def postorder_traversal(self, node, result_list):
        # LRV (Lewy, Prawy, Węzeł)
        if node:
            self.postorder_traversal(node.left, result_list)
            self.postorder_traversal(node.right, result_list)
            result_list.append(node.key)

    # Usuwanie (uproszczona wersja, dla pełnej implementacji trzeba obsłużyć wszystkie przypadki)
    def delete(self, key):
        self.root = self._delete_recursive(self.root, key)

    def _delete_recursive(self, current_node, key):
        if current_node is None:
            return current_node # Klucza nie ma w drzewie

        if key < current_node.key:
            current_node.left = self._delete_recursive(current_node.left, key)
        elif key > current_node.key:
            current_node.right = self._delete_recursive(current_node.right, key)
        else: # Znaleziono węzeł do usunięcia
            # Przypadek 1: Węzeł jest liściem lub ma jedno dziecko
            if current_node.left is None:
                return current_node.right
            elif current_node.right is None:
                return current_node.left
            
            # Przypadek 2: Węzeł ma dwoje dzieci
            # Znajdź następnika inorder (najmniejszy w prawym poddrzewie)
            temp_node = self._find_min_value_node(current_node.right)
            current_node.key = temp_node.key # Skopiuj wartość następnika
            # Usuń następnika inorder z prawego poddrzewa
            current_node.right = self._delete_recursive(current_node.right, temp_node.key)
        return current_node

    def _find_min_value_node(self, node):
        current = node
        while current.left is not None:
            current = current.left
        return current

# Testowanie BST
bst = BinarySearchTree()
elements_to_insert = [50, 30, 70, 20, 40, 60, 80, 25]
print(f"Wstawiam elementy do BST: {elements_to_insert}")
for el in elements_to_insert:
    bst.insert(el)

# Wyszukiwanie
print(f"Szukam 40: {'Znaleziono' if bst.search(40) else 'Nie znaleziono'}")
print(f"Szukam 90: {'Znaleziono' if bst.search(90) else 'Nie znaleziono'}")

# Przechodzenie
inorder_res = []
bst.inorder_traversal(bst.root, inorder_res)
print(f"Przechodzenie In-order (posortowane): {inorder_res}")

preorder_res = []
bst.preorder_traversal(bst.root, preorder_res)
print(f"Przechodzenie Pre-order: {preorder_res}")

postorder_res = []
bst.postorder_traversal(bst.root, postorder_res)
print(f"Przechodzenie Post-order: {postorder_res}")

# Usuwanie
print(f"Usuwam 20 (liść)")
bst.delete(20)
inorder_res_after_delete1 = []
bst.inorder_traversal(bst.root, inorder_res_after_delete1)
print(f"In-order po usunięciu 20: {inorder_res_after_delete1}")

print(f"Usuwam 30 (węzeł z jednym dzieckiem - prawym 40, lewym 25)")
bst.delete(30) # Powinien być zastąpiony przez 40 (lub 25 jeśli by było lewe)
inorder_res_after_delete2 = []
bst.inorder_traversal(bst.root, inorder_res_after_delete2)
print(f"In-order po usunięciu 30: {inorder_res_after_delete2}")


print(f"Usuwam 50 (korzeń, węzeł z dwoma dziećmi)")
bst.delete(50) # Powinien być zastąpiony przez następnika inorder (60)
inorder_res_after_delete3 = []
bst.inorder_traversal(bst.root, inorder_res_after_delete3)
print(f"In-order po usunięciu 50: {inorder_res_after_delete3}")

# Zbudowanie niezbalansowanego drzewa (np. wstawianie posortowanych danych)
print("\nPrzykład niezbalansowanego drzewa (wstawianie posortowanych):")
unbalanced_bst = BinarySearchTree()
sorted_data = [10, 20, 30, 40, 50]
for el in sorted_data:
    unbalanced_bst.insert(el)

inorder_unbalanced = []
unbalanced_bst.inorder_traversal(unbalanced_bst.root, inorder_unbalanced)
print(f"In-order dla niezbalansowanego drzewa: {inorder_unbalanced}")
# (Wizualnie, to drzewo będzie wyglądać jak lista połączona idąca w prawo)
# Aby to pokazać, można by zaimplementować prostą funkcję wizualizującą strukturę drzewa.
# np. def display_tree(node, level=0, prefix="Root:"):
#         if node is not None:
#             print(" " * (level*4) + prefix + str(node.key))
#             if node.left is not None or node.right is not None:
#                 display_tree(node.left, level + 1, "L--- ")
#                 display_tree(node.right, level + 1, "R--- ")
# print("Struktura niezbalansowanego drzewa:")
# display_tree(unbalanced_bst.root)