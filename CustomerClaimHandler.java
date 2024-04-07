import java.util.*;

public class CustomerClaimHandler implements ClaimProcessManager {
    private final CustomerManager customerManager;
    private final ClaimManager claimManager;
    private final DateParser dateParser;

    public CustomerClaimHandler(CustomerManager customerManager, ClaimManager claimManager) {
        this.customerManager = customerManager;
        this.claimManager = claimManager;
        this.dateParser = new DateParser();
    }

    @Override
    public void add() {
        Scanner scanner = DataInput.getDataInput().getScanner();
        System.out.println("Enter customer ID: ");
        String id = scanner.nextLine();
        Customer customer = customerManager.findCustomerById(id);
        if (customer == null) {
            System.out.println("Customer with ID " + id + " not found.");
            return;
        }

        ClaimManager claimManager1 = customer.getClaims();
        while (true) {
            Claim claim = new Claim();
            ClaimCreator claimCreator = new ClaimCreator(claim, new ClaimViewText());
            claim = claimCreator.createClaim();


            if (claimManager.findClaimById(claim.getId()) != null) {
                System.out.println("Claim with ID " + claim.getId() + " already exists. Please enter a different ID.");
                continue;
            }
            claimManager.addClaim(claim);
            claimManager1.addClaim(claim);

            System.out.println("Do you want to add another claim? (yes/no): ");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (!choice.equals("yes")) {
                System.out.println("Claim has been added successfully.");
                break;
            }
        }
    }

    @Override
    public void delete() {
        Scanner scanner = DataInput.getDataInput().getScanner();
        System.out.println("Enter claim ID to delete: ");
        String claim_id = scanner.nextLine();
        Claim claim = claimManager.findClaimById(claim_id);
        if (claim == null) {
            System.out.println("There no this claim with ID: " + claim_id);
            return;
        }

        Customer customer = customerManager.findCustomerByClaim(claim);
        boolean removed = customer.removeClaim(claim);
        if (removed) {
            claimManager.deleteClaim(claim);
            customerManager.updateCustomer(customer);
            System.out.println("Claim with ID " + claim_id + " has been deleted successfully.");
        } else {
            System.out.println("Failed to delete claim with ID " + claim_id);
        }
    }

    @Override
    public void update() {
        Scanner scanner = DataInput.getDataInput().getScanner();

        // Prompt user to enter claim ID to update
        System.out.println("Enter claim ID to update: ");
        String claimId = scanner.nextLine();
        Claim claimToUpdate = claimManager.findClaimById(claimId);

        // Check if the claim exists
        if (claimToUpdate == null) {
            System.out.println("There is no claim with ID: " + claimId);
            return;
        }

        // Update loop
        while (true) {
            // Prompt user to select which part of the claim they want to update
            System.out.println("Which part of the claim do you want to update?");
            System.out.println("1. Claim Date");
            System.out.println("2. Insured People");
            System.out.println("3. Card Number");
            System.out.println("4. Exam Date");
            System.out.println("5. Documents");
            System.out.println("6. Status");
            System.out.println("7. Claim Amount");
            System.out.println("8. Receive Banking Info");
            System.out.println("9. Finish updating");
            System.out.println("Enter your choice: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter new claim date (yyyy-MM-dd): ");
                    String newClaimDateStr = scanner.nextLine();
                    Date newClaimDate = dateParser.parseDate(newClaimDateStr);
                    if (newClaimDate != null) {
                        claimToUpdate.setClaimDate(newClaimDate);
                    }
                }
                case 2 -> {
                    System.out.println("Enter new insured people: ");
                    String newInsuredPeople = scanner.nextLine();
                    claimToUpdate.setInsuredPeople(newInsuredPeople);
                }
                case 3 -> {
                    System.out.println("Enter new card number: ");
                    String newCardNumber = scanner.nextLine();
                    claimToUpdate.setCardNumber(newCardNumber);
                }
                case 4 -> {
                    System.out.println("Enter new exam date (yyyy-MM-dd): ");
                    String newExamDateStr = scanner.nextLine();
                    Date newExamDate = dateParser.parseDate(newExamDateStr);
                    if (newExamDate != null) {
                        claimToUpdate.setExamDate(newExamDate);
                    }
                }
                case 5 -> {
                    // Handle updating documents
                }
                case 6 -> {
                    System.out.println("Enter new status: ");
                    String newStatus = scanner.nextLine();
                    claimToUpdate.setStatus(newStatus);
                }
                case 7 -> {
                    System.out.println("Enter new claim amount: ");
                    double newClaimAmount;
                    try {
                        newClaimAmount = Double.parseDouble(scanner.nextLine());
                        claimToUpdate.setClaimAmount(newClaimAmount);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input for claim amount. Please enter a valid number.");
                    }
                }
                case 8 -> {
                    ReceiveBankingInfo receiveBankingInfo = new ReceiveBankingInfo();
                    ReceiveBankingViewText receiveBankingViewText = new ReceiveBankingViewText();
                    ReceiveBankingCreator receiveBankingCreator = new ReceiveBankingCreator(receiveBankingInfo, receiveBankingViewText);
                    receiveBankingCreator.createBankingInfo();
                    claimToUpdate.setReceiveBankingInfo(receiveBankingInfo);
                }
                case 9 -> {
                    // Finish updating, exit the loop
                    System.out.println("Finish updating.");
                    claimManager.updateClaim(claimToUpdate);
                    System.out.println("Claim has been updated successfully.");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }

            // Ask if the user wants to continue updating
            System.out.println("Do you want to continue updating? (yes/no): ");
            String continueChoice = scanner.nextLine().trim().toLowerCase();
            if (!continueChoice.equals("yes")) {
                // Exit the loop if the user doesn't want to continue updating
                System.out.println("Finish updating.");
                claimManager.updateClaim(claimToUpdate);
                System.out.println("Claim has been updated successfully.");
                return;
            }
        }
    }

    @Override
    public Claim getOne() {
        Scanner scanner = DataInput.getDataInput().getScanner();
        System.out.println("Enter claim ID to retrieve: ");
        String claim_id = scanner.nextLine();
        Claim claim = claimManager.findClaimById(claim_id);
        if (claim == null) {
            System.out.println("There is no claim with ID: " + claim_id);
            return null;
        }
        System.out.println("Claim found successfully.");
        return claim;
    }

    @Override
    public List<Claim> getAll() {
        return claimManager.getAllClaims();
    }
}
