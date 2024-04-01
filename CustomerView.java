import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
public abstract class CustomerView {

    public static final String CUSTOMER_ID = "CUSTOMER_ID";
    public static final String FULL_NAME = "FULL_NAME";
    public static final String insuranceCard = "insuranceCard";

    private ArrayList<Claim> claims;

    public abstract void display(Customer c);

    public abstract Map<String, String> displayNewCustomerForm();

}


class CustomerViewText extends CustomerView {

    @Override
    public void display(Customer customer) {
        System.out.println("----------------------------");
        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Customer Name: " + customer.getFullName());
        System.out.println("----------------------------");
        System.out.println();
    }

    @Override
    public Map<String, String> displayNewCustomerForm() {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> data = new HashMap<>();
        System.out.println("New Customer Form: ");
        System.out.println("Enter customer id: ");
        data.put(CUSTOMER_ID, scanner.nextLine());
        System.out.println("Enter customer name: ");
        data.put(FULL_NAME, scanner.nextLine());
        return data;
    }
}

