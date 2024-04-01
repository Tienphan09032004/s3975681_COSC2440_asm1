import java.util.Map;
import java.util.Scanner;

public class CustomerCreator {
    CustomerView view;

    public CustomerCreator(CustomerView view) {
        this.view = view;
    }

    public void createCustomer(CustomerManager customerManager) {
        String answer = "Y";
        Scanner scanner = DataInput.getDataInput().getScanner();
        while (answer.equalsIgnoreCase("Y")) {
            Map<String, String> data = view.displayNewCustomerForm();
            String id = data.get(CustomerView.CUSTOMER_ID);
            String name = data.get(CustomerView.FULL_NAME);

            System.out.println("Enter role (CardHolder or Independent):");
            String role = scanner.nextLine();

            Customer customer = null;

            if (role.equals("CardHolder")) {
                customer = new CardHolder(id, name);
            } else if (role.equals("Independent")) {
                customer = new Independent(id, name);
            } else {
                System.out.println("Enter role (CardHolder or Independent): ");
                continue;
            }

            customerManager.addCustomer(customer);

            view.display(customer);

            System.out.println("Continue? ");
            answer = scanner.nextLine();
        }
    }
}