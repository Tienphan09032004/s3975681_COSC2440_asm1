import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main {

        public static void main(String[] args) {

            CardHolder C = new CardHolder("1", "John Doe");
            Independent I = new Independent("2", "Jane Smith");

            HashSet<Customer> customers = new HashSet<>();
            customers.add(C);
            customers.add(I);

            CustomerManager customerManager = new CustomerManager(customers);
            CustomerClaimHandler customerClaimHandler = new CustomerClaimHandler(customerManager);

            // Create and add claims
            customerClaimHandler.createAndAddClaim();

            // Print claims for each customer
            for (Customer customer : customerManager.getCustomers()) {
                System.out.println("Customer ID: " + customer.getId());

                System.out.println("Claims:");
                for (Claim claim : customer.getClaims()) {
                    System.out.println(claim); // Assuming you have overridden toString() method in Claim class
                }
                System.out.println("--------------");
            }
        }
    }


