package wsb.po.banking;

import java.io.*;
import java.util.ArrayList;

public class Customer implements Serializable {

    private static final long serialVersionUID = 6607357493859031942L;

    private final String firsName;
    private final String lastName;

    final private ArrayList<Account> accounts = new ArrayList<>();

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    public void addAccount(Account a) {
        accounts.add(a);
    }

    public Account getAccount(int i) {
        if (i >= getNumberOfAccounts()) {
            return null;
        }
        return accounts.get(i);
    }

    public Customer(String firsName, String lastName) {
        this.firsName = firsName;
        this.lastName = lastName;
    }

    public String getFirsName() {
        return firsName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firsName='" + getFirsName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", number of accounts=" + getNumberOfAccounts() +
                '}';
    }


    public void save(int id) throws IOException {
        String fname = "Klient_"+id+".ser";
        System.out.println("Saving "+this+" to " + fname);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname));
        oos.writeObject(this);
    }

    public static Customer load(int id) throws IOException, ClassNotFoundException {
        String fname = "Klient_"+id+".ser";
        System.out.println("Loading customer"+" from " + fname);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname));
        return (Customer)ois.readObject();

    }
}
