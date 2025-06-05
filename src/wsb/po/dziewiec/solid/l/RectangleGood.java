package wsb.po.dziewiec.solid.l;

// DOBRZE: Zachowanie LSP

// Interfejs definiujący wspólne zachowanie
interface Shape {
    int getArea();
}

class RectangleGood implements Shape {
    private int width;
    private int height;

    public RectangleGood(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    @Override
    public int getArea() {
        return width * height;
    }
}

class SquareGood implements Shape { // Kwadrat jest osobnym kształtem
    private int side;

    public SquareGood(int side) {
        this.side = side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getSide() { return side; }

    @Override
    public int getArea() {
        return side * side;
    }
}

class LSPDemoGood {
    public static void printArea(Shape shape) {
        System.out.println("Area: " + shape.getArea());
    }

    // Klient, który specyficznie oczekuje prostokąta i możliwości zmiany jego boków niezależnie
    public static void manipulateRectangle(RectangleGood rect) {
        rect.setWidth(5);
        rect.setHeight(10);
        System.out.println("Manipulated Rectangle Area: " + rect.getArea() + " (Expected 50)");
        if (rect.getArea() != 50) {
            System.err.println("Unexpected area for RectangleGood!");
        }
    }


    public static void main(String[] args) {
        RectangleGood rect = new RectangleGood(5, 10);
        printArea(rect); // Area: 50
        manipulateRectangle(rect);

        SquareGood sq = new SquareGood(7);
        printArea(sq); // Area: 49

        // Nie możemy już przekazać SquareGood do manipulateRectangle, co jest dobre,
        // bo manipulateRectangle oczekuje semantyki prostokąta (niezależne boki).
        // manipulateRectangle(sq); // Błąd kompilacji: incompatible types
    }
}
