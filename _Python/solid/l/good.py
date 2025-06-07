# DOBRZE: Zachowanie LSP (jedna z możliwych implementacji)

from abc import ABC, abstractmethod

class Shape(ABC): # Bardziej ogólna abstrakcja
    @abstractmethod
    def get_area(self):
        pass

class Rectangle(Shape):
    def __init__(self, width, height):
        self.width = width
        self.height = height

    def set_width(self, width):
        self.width = width

    def set_height(self, height):
        self.height = height
        
    def get_area(self):
        return self.width * self.height

class Square(Shape): # Kwadrat jest osobnym kształtem
    def __init__(self, side):
        self.side = side

    def set_side(self, side):
        self.side = side
        
    def get_area(self):
        return self.side * self.side

# Funkcja kliencka, która operuje na abstrakcji Shape
def print_area(shape: Shape):
    print(f"Area: {shape.get_area()}")

# Użycie:
rect = Rectangle(5, 10)
print_area(rect) # Area: 50

sq = Square(7)
print_area(sq) # Area: 49

# Jeśli potrzebujemy zmieniać wymiary:
rect.set_width(3)
rect.set_height(6)
print_area(rect) # Area: 18

sq.set_side(4)
print_area(sq) # Area: 16