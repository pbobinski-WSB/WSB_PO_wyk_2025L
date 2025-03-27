package wsb.po.banking;

public class BankAccount {

    private double balance;

    /**
     * Constructs a bank account with a zero balance.
     */
    public BankAccount() {

        balance = 0;
    }

    /**
     * Constructs a bank account with a given balance.
     *
     * @param balance the initial balance
     */
    public BankAccount(double balance) {

        this.balance = balance;
    }

    /**
     * Deposits money into the bank account.
     *
     * @param balance the amount to deposit
     */
    public void deposit(double balance) {

        this.balance = this.balance + balance;
    }

    /**
     * Withdraws money from the bank account.
     *
     * @param balance the amount to withdraw
     */
    public void withdraw(double balance) {

        this.balance = this.balance - balance;
    }

    /**
     * Gets the current balance of the bank account.
     *
     * @return the current balance
     */
    public double getBalance() {

        return balance;
    }

    @Override
    public String toString() {
        return "Wartość konta = " + this.balance;
    }


}


