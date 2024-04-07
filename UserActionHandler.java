import java.util.Scanner;

public class UserActionHandler {
    CustomerClaimHandler customerClaimHandler;

    public UserActionHandler(CustomerClaimHandler customerClaimHandler) {
        this.customerClaimHandler = customerClaimHandler;
    }



    public void performAction() {
        Scanner scanner = new Scanner(System.in);
        boolean returnToMainMenu = false;

        do {

            System.out.println("Choose an action:");
            System.out.println("1. Add a new customer claim");
            System.out.println("2. Delete a customer claim");
            System.out.println("3. Update a customer claim");
            System.out.println("4. View details of a customer claim");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");


            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number.");
                continue;
            }


            switch (choice) {
                case 1:
                    customerClaimHandler.add();
                    System.out.println("Performing add action...");

                    break;
                case 2:
                    customerClaimHandler.delete();
                    System.out.println("Performing delete action...");

                    break;
                case 3:
                    customerClaimHandler.update();
                    System.out.println("Performing update action...");

                    break;
                case 4:
                    customerClaimHandler.getAll();
                    System.out.println("Performing view action...");

                    break;
                case 5:
                    customerClaimHandler.getOne();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }


            System.out.print("Do you want to return to the main menu? (yes/no): ");
            String returnChoice = scanner.nextLine().trim().toLowerCase();
            returnToMainMenu = returnChoice.equals("yes");
        } while (returnToMainMenu);
    }
}
