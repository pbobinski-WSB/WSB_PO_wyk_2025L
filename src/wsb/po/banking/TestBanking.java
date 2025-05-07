package wsb.po.banking;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

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

    public static List<String> findCustomerFiles (String path) {
        File folder = new File(path);
        List<String> files = new ArrayList<>();
        Pattern template = Pattern.compile("^Klient_[-]?\\d+\\.ser$");
        if (folder.exists() && folder.isDirectory()) {
            File[] files1 = folder.listFiles();
            if (files1 != null) {
                for (File plik : files1) {
                    if (plik.isFile() && template.matcher(plik.getName()).matches()) {
                        files.add(plik.getName());
                    }
                }
            }
        }
        return files;
    }

    public static void main(String[] args) {

        Customer klient1 = null;
        Customer klient2 = null;
        Account account = null;

        List<String> savedCustomers = findCustomerFiles(".");

        if (savedCustomers.contains("Klient_1.ser")) {
            try {
                klient1 = Customer.load(1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            klient1 = new Customer("Simms", "Jane");
            account = new SavingsAccount(500, 2);
            klient1.addAccount(account);
            account = new CheckingAccount(200);
            klient1.addAccount(account);
        }

        if (savedCustomers.contains("Klient_2.ser")) {
            try {
                klient2 = Customer.load(2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        } else {
            klient2 = new Customer("Bryant", "Owen");
            account = new SavingsAccount(200, 5);
            klient2.addAccount(account);
            account = new CheckingAccount(1500);
            klient2.addAccount(account);
            account = new SavingsAccount(200, 10);
            klient2.addAccount(account);
        }
        try {
            klient1.save(1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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
