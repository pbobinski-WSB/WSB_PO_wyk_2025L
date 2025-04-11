package wsb.po.banking;

public class CheckingAccount extends Account {

    private double overdraftProtection = 0;

    public CheckingAccount(double balance) {
        super(balance);
    }

    public CheckingAccount(double balance, double overdraftProtection) {
        super(balance);
        this.overdraftProtection = overdraftProtection;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > getBalance() + overdraftProtection) {
            return false;
        }
        if (amount > getBalance()) {
            //użyć limitu
            double ileBrakuje = amount - getBalance();
            overdraftProtection -= ileBrakuje;
            super.withdraw(getBalance());
        } else {
            super.withdraw(amount);
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString() +
                " CheckingAccount{" +
                "overdraftProtection=" + overdraftProtection +
                '}';
    }
}
