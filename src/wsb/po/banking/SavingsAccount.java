package wsb.po.banking;

public class SavingsAccount extends Account {

    private double interestRate = 0;

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }
}
