package Ch4JavaNetworking;

// BankServer.java
import java.rmi.Naming;

public class BankServer {
    public static void main(String[] args) {
        try {
            BankImpl bank = new BankImpl();
            Naming.rebind("rmi://localhost:5000/bank", bank);
            System.out.println("Bank Server is running...");
        } catch (Exception e) {
            System.out.println("Server Error: " + e);
        }
    }
}
