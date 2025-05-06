package wsb.po.banking;

public class TestBanking
{

    public static void printAccount(Account ba, int i) {
        System.out.println("\tKonto " + (i + 1) + " " + ba + " "
                        + (ba instanceof SavingsAccount ? "SA" : "") + " "
                //+ (ba instanceof CheckingAccount ? "CA" : "")
        );
        if (ba instanceof SavingsAccount) {
            System.out.println("\t\tProcent " + " " + ((SavingsAccount) ba).getInterestRate());
        }
    }

    public static void main(String[] args) {

        Customer klient1 = new Customer("Simms", "Jane");

        Customer klient2 = new Customer("Bryant", "Owen");

        Account account = new SavingsAccount(500, 2);
        klient1.addAccount(account);
        account = new CheckingAccount(200);
        klient1.addAccount(account);
        account = new SavingsAccount(200, 5);
        klient2.addAccount(account);
        account = new CheckingAccount(1500);
        klient2.addAccount(account);
        account = new SavingsAccount(200, 10);
        klient2.addAccount(account);

        System.out.println("Klient 1 " + klient1);
        for (int i = 0; i < klient1.getNumberOfAccounts(); i++) {
            printAccount(klient1.getAccount(i), i);

        }
        System.out.println("Klient 2 " + klient2);
        for (int i = 0; i < klient2.getNumberOfAccounts(); i++) {
            printAccount(klient2.getAccount(i), i);
        }

        account = new CheckingAccount(100,50);
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
