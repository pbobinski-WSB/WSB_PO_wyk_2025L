package wsb.po.banking;

public class TestBanking {

    public static void main(String[] args) {

        Customer klient1 = new Customer("Simms", "Jane");

        Customer klient2 = new Customer("Bryant", "Owen");

        Account account = new Account(500);
        klient1.addAccount(account);
        account = new Account(200);
        klient1.addAccount(account);
        account = new Account(200);
        klient2.addAccount(account);
        account = new Account(1500);
        klient2.addAccount(account);
        account = new Account(200);
        klient2.addAccount(account);

        System.out.println("Klient 1 " + klient1);
        for (int i = 0; i < klient1.getNumberOfAccounts(); i++) {
            System.out.println("\tKonto " + (i + 1) + " " + klient1.getAccount(i));
        }
        System.out.println("Klient 2 " + klient2);
        for (int i = 0; i < klient2.getNumberOfAccounts(); i++) {
            System.out.println("\tKonto " + (i + 1) + " " + klient2.getAccount(i));
        }


    }

}
