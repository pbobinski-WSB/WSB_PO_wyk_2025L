package wsb.po.banking.domain;

public class OverdraftException extends Exception {

    private double deficit = 0;

    public OverdraftException(String message, double deficit) {
        super(message);
        this.deficit = deficit;
    }

    public double getDeficit() {
        return deficit;
    }
}
