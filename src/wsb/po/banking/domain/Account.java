package wsb.po.banking.domain;

import java.io.Serializable;

public class Account implements Serializable {

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
     * @param amount the amount to deposit
     */
    public void deposit (double amount) throws NegativeDepositException {
        if (amount < 0) {
            throw new NegativeDepositException();
        }
        balance += amount; // balance = balance + amount
    }

    /**
     * Withdraws money from the bank account.
     *
     * @param amount the amount to withdraw
     */
    public void withdraw (double amount) throws OverdraftException{
        if (amount > balance) {
            throw new OverdraftException("przekroczono saldo",amount - balance);
        }
        balance -= amount; // balance = balance - amount
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


