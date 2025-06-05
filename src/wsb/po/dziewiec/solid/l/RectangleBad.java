package wsb.po.dziewiec.solid.l;

// ŹLE: Klasa łamie LSP
class RectangleBad {
    protected int width;
    protected int height;

    public RectangleBad(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getArea() {
        return width * height;
    }
}

class SquareBad extends RectangleBad { // Kwadrat "jest" prostokątem, ale...
    public SquareBad(int side) {
        super(side, side);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width); // Kwadrat musi mieć równe boki
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height); // Kwadrat musi mieć równe boki
    }
}

class LSPDemoBad {
    public static void useRectangle(RectangleBad r) {
        r.setWidth(5);
        r.setHeight(10);
        // Oczekujemy, że pole będzie 5 * 10 = 50
        // Dla RectangleBad: r.getArea() == 50
        // Dla SquareBad: ostatnie ustawienie (setHeight(10)) sprawi, że width też będzie 10,
        // więc pole wyniesie 10 * 10 = 100. Niespodzianka!
        System.out.println("Area: " + r.getArea() + ", Expected: 50, Got: " + r.getArea());
        if (r.getArea() != 50) {
            System.err.println("LSP Violation! Expected area 50, but got " + r.getArea());
        }
    }

    public static void main(String[] args) {
        RectangleBad rect = new RectangleBad(2, 3);
        System.out.println("Testing RectangleBad:");
        useRectangle(rect); // Działa poprawnie

        SquareBad sq = new SquareBad(4);
        System.out.println("\nTesting SquareBad:");
        useRectangle(sq); // Tutaj nastąpi naruszenie LSP
    }
}
