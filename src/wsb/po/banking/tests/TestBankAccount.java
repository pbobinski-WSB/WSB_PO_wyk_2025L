package wsb.po.banking.tests;

import wsb.po.banking.domain.Account;
import wsb.po.banking.domain.CheckingAccount;
import wsb.po.banking.domain.NegativeDepositException;
import wsb.po.banking.domain.OverdraftException;

public class TestBankAccount {

    public static void main(String[] args) {

        Account account = new CheckingAccount(100,50);
        System.out.println(account);
        try {
            account.withdraw(300);
        } catch (OverdraftException ex) {
            System.out.println(ex);
            System.out.println("deficit: " + ex.getDeficit());
        }
        try {
            account.deposit(-50);
        } catch (NegativeDepositException ex) {
            System.out.println(ex);
        }
        System.out.println(account);
        try {
            account.withdraw(120);
        } catch (OverdraftException ex) {
            System.out.println(ex);
            System.out.println("deficit: " + ex.getDeficit());
        }
        try {
            account.deposit(50);
        } catch (NegativeDepositException ex) {
            System.out.println(ex);
        }
        System.out.println(account);


    }

}
