package wsb.po.banking;

public class Account {

    private double balance;

    /**
     * Constructs a bank account with a zero balance.
     */
    public Account() {

        balance = 0;
    }

    /**
     * Constructs a bank account with a given balance.
     *
     * @param balance the initial balance
     */
    public Account(double balance) {

        this.balance = balance;
    }

    /**
     * Deposits money into the bank account.
     *
     * @param balance the amount to deposit
     */
    public boolean deposit(double balance) {
        //proste zabezpieczenie
        if (balance < 0) {
            return false;
        }
        this.balance += balance; // balance = balance + amount
        return true;
    }

    /**
     * Withdraws money from the bank account.
     *
     * @param balance the amount to withdraw
     */
    public boolean withdraw(double balance) {
        //proste zabezpieczenie
        if (balance > this.balance) {
            return false;
        }
        this.balance -= balance; // balance = balance - amount
        return true;
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


