import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main {

        public static void main(String[] args) {
            CardHolder C = new CardHolder("1", "John Doe");
            Independent I = new Independent("2", "Jane Smith");
            HashSet<Customer> customers = new HashSet<>();
            HashSet<Claim> claims = new HashSet<>();
            customers.add(C);
            customers.add(I);
            CustomerManager customerManager = new CustomerManager(customers);
            ClaimManager claimManager= new ClaimManager(claims);
            CustomerClaimHandler customerClaimHandler = new CustomerClaimHandler(customerManager, claimManager );
            customerClaimHandler.add();
            for (Customer customer : customerManager.getCustomers()) {
                System.out.println("Customer ID: " + customer.getId());
                System.out.println("Claims:");
                for (Claim claim : customer.getClaims()) {
                    System.out.println(claim);
                }
                System.out.println("--------------");
            }
            customerClaimHandler.delete();
            for (Customer customer : customerManager.getCustomers()) {
                System.out.println("Customer ID: " + customer.getId());
                System.out.println("Claims:");
                for (Claim claim : customer.getClaims()) {
                    System.out.println(claim);
                }
                System.out.println("--------------");
            }
            System.out.println(claimManager);
            System.out.println(customerManager);
        }
}


