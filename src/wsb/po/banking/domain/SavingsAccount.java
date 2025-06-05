package wsb.po.banking.domain;

public class SavingsAccount extends Account {

    private double interestRate = 0;

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String toString() {
        return " SavingsAccount{" +
                '}' + super.toString();
    }


}
