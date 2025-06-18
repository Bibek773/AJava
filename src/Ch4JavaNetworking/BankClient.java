package Ch4JavaNetworking;

// BankClient.java
import java.rmi.Naming;

public class BankClient {
    public static void main(String[] args) {
        try {
            Bankk bank = (Bankk) Naming.lookup("rmi://localhost:5000/bank");
            bank.deposit(1000);
            bank.withdraw(500);
            double balance = bank.showBalance();
            System.out.println("Current Balance: " + balance);
        } catch (Exception e) {
            System.out.println("Client Error: " + e);
        }
    }
}
