package wsb.po.banking.reports;

import wsb.po.banking.domain.Bank;
import wsb.po.banking.domain.Account;
import wsb.po.banking.domain.SavingsAccount;

public class CustomerReport {

    private void printAccount(Account ba, int i) {
        System.out.println("\tKonto " + (i + 1) + " " + ba + " "
                        + (ba instanceof SavingsAccount ? "SA" : "") + " "
                //+ (ba instanceof CheckingAccount ? "CA" : "")
        );
        if (ba instanceof SavingsAccount) {
            System.out.println("\t\tProcent " + " " + ((SavingsAccount) ba).getInterestRate());
        }
    }
    public void generateRepotr() {

        //Bank bank = new Bank();
        Bank bank = Bank.getBank();

        for (int i = 0; i < bank.getNumberOfCustomers(); i++) {
            System.out.println("Customer ["+(i+1)+"] is "+bank.getCustomer(i));
            for (int j = 0; j < bank.getCustomer(i).getNumberOfAccounts(); j++) {
                printAccount(bank.getCustomer(i).getAccount(j),(j+1));
            }
        }

    }

}
