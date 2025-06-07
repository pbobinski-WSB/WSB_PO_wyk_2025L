# ŹLE: Klasa łamie LSP
class Rectangle:
    def __init__(self, width, height):
        self._width = width
        self._height = height

    def get_width(self):
        return self._width

    def set_width(self, width):
        self._width = width

    def get_height(self):
        return self._height

    def set_height(self, height):
        self._height = height

    def get_area(self):
        return self._width * self._height

class Square(Rectangle): # Kwadrat "jest" prostokątem, ale...
    def __init__(self, side):
        super().__init__(side, side)

    def set_width(self, width):
        self._width = width
        self._height = width # Kwadrat musi mieć równe boki

    def set_height(self, height):
        self._height = height
        self._width = height # Kwadrat musi mieć równe boki

# Funkcja kliencka, która oczekuje zachowania prostokąta
def use_rectangle(rect: Rectangle):
    rect.set_width(5)
    rect.set_height(10)
    # Oczekujemy, że pole będzie 5 * 10 = 50
    # Dla prostokąta: rect.get_area() == 50
    # Dla kwadratu: ostatnie ustawienie (set_height(10)) sprawi, że width też będzie 10,
    # więc pole wyniesie 10 * 10 = 100. Niespodzianka!
    print(f"Area: {rect.get_area()}, Expected: 50, Got: {rect.get_area()}")
    assert rect.get_area() == 50 # To się wywali dla kwadratu

# Użycie:
rect = Rectangle(2, 3)
use_rectangle(rect) # Działa poprawnie

sq = Square(4)
# use_rectangle(sq) # Tutaj poleci AssertionError, bo kwadrat nie zachowuje się jak prostokąt
                    # po ustawieniu różnych wartości dla width i height.