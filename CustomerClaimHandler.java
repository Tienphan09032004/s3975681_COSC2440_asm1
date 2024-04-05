import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerClaimHandler {
    private final CustomerManager customerManager;

    public CustomerClaimHandler(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    public void createAndAddClaim() {
        Scanner scanner = DataInput.getDataInput().getScanner();
        System.out.println("Enter customer ID: ");
        String id = scanner.nextLine();

        Customer customer = customerManager.findCustomerById(id);
        if (customer == null) {
            System.out.println("Customer with ID " + id + " not found.");
            return; // Exit the method if customer is not found
        }

        List<Claim> claims = new ArrayList<>();
        while (true) {
            Claim claim = new Claim();
            ClaimCreator claimCreator = new ClaimCreator(claim, new ClaimViewText());
            claim=claimCreator.createClaim();
            claims.add(claim);

            System.out.println("Do you want to add another claim? (yes/no): ");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (!choice.equals("yes")) {
                break; // Exit the loop if user does not want to add another claim
            }
        }

        // Add all the claims to the customer
        for (Claim claim : claims) {
            customer.addClaim(claim);
        }
    }
}
