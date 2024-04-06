import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main {

        public static void main(String[] args) {
            CardHolder C = new CardHolder("c-1234567", "John Doe");
            Independent I = new Independent("c-1234567", "Jane Smith");
            HashSet<Customer> customers = new HashSet<>();
            CustomerManager customerManager = new CustomerManager(customers);
            customerManager.addCustomer(C);
            customerManager.addCustomer(I);
            HashSet<Claim> claims = new HashSet<>();





            System.out.println(customerManager);
        }
}


