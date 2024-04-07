import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

// Main.java
public class Main {
    public static void main(String[] args) {

        DateParser dateParser= new DateParser();
        Claim claim1 = new Claim("f-1234567890", dateParser.parseDate("2024-04-01"), "John Doe", "1234 5678 9012 3456",
                dateParser.parseDate("2024-04-02"), 1000.00, "New",
                new ReceiveBankingInfo("AsiaBank", "John Doe", "1234567"),
                new ArrayList<String>() {{
                    add("f-1234567890_1234567890_Document1.pdf");
                    add("f-1234567890_1234567890_Document2.pdf");
                }});

        Claim claim2 = new Claim("f-2345678901", dateParser.parseDate("2024-04-02"), "Jane Smith", "2345 6789 0123 4567",
                dateParser.parseDate("2024-04-03"), 1500.00, "Processing",
                new ReceiveBankingInfo("AsiaBank", "Jane Smith", "2345678"),
                new ArrayList<String>() {{
                    add("f-2345678901_2345678901_Document1.pdf");
                    add("f-2345678901_2345678901_Document2.pdf");
                }});

        Claim claim3 = new Claim("f-3456789012", dateParser.parseDate("2024-04-03"), "David Johnson", "3456 7890 1234 5678",
                dateParser.parseDate("2024-04-04"), 2000.00, "Done",
                new ReceiveBankingInfo("AsiaBank", "David Johnson", "3456789"),
                new ArrayList<String>() {{
                    add("f-3456789012_3456789012_Document1.pdf");
                    add("f-3456789012_3456789012_Document2.pdf");
                }});

        Claim claim4 = new Claim("f-4567890123", dateParser.parseDate("2024-04-04"), "Emily Brown", "4567 8901 2345 6789",
                dateParser.parseDate("2024-04-05"), 2500.00, "New",
                new ReceiveBankingInfo("AsiaBank", "Emily Brown", "4567890"),
                new ArrayList<String>() {{
                    add("f-4567890123_4567890123_Document1.pdf");
                    add("f-4567890123_4567890123_Document2.pdf");
                }});

        Claim claim5 = new Claim("f-5678901234", dateParser.parseDate("2024-04-05"), "Michael Davis", "5678 9012 3456 7890",
                dateParser.parseDate("2024-04-06"), 3000.00, "Processing",
                new ReceiveBankingInfo("AsiaBank", "Michael Davis", "5678901"),
                new ArrayList<String>() {{
                    add("f-5678901234_5678901234_Document1.pdf");
                    add("f-5678901234_5678901234_Document2.pdf");
                }});

        Claim claim6 = new Claim("f-6789012345",dateParser.parseDate("2024-04-06"), "Sarah Wilson", "6789 0123 4567 8901",
                dateParser.parseDate("2024-04-07"), 3500.00, "Done",
                new ReceiveBankingInfo("AsiaBank", "Sarah Wilson", "6789012"),
                new ArrayList<String>() {{
                    add("f-6789012345_6789012345_Document1.pdf");
                    add("f-6789012345_6789012345_Document2.pdf");
                }});

        Claim claim7 = new Claim("f-7890123456", dateParser.parseDate("2024-04-07"), "Christopher Martinez", "7890 1234 5678 9012",
                dateParser.parseDate("2024-04-08"), 4000.00, "New",
                new ReceiveBankingInfo("AsiaBank", "Christopher Martinez", "7890123"),
                new ArrayList<String>() {{
                    add("f-7890123456_7890123456_Document1.pdf");
                    add("f-7890123456_7890123456_Document2.pdf");
                }});

        Claim claim8 = new Claim("f-8901234567", dateParser.parseDate("2024-04-08"), "Jessica Taylor", "8901 2345 6789 0123",
                dateParser.parseDate("2024-04-09"), 4500.00, "Processing",
                new ReceiveBankingInfo("AsiaBank", "Jessica Taylor", "8901234"),
                new ArrayList<String>() {{
                    add("f-8901234567_8901234567_Document1.pdf");
                    add("f-8901234567_8901234567_Document2.pdf");
                }});

        Claim claim9 = new Claim("f-9012345678", dateParser.parseDate("2024-04-09"), "Andrew Anderson", "9012 3456 7890 1234",
                dateParser.parseDate("2024-04-10"), 5000.00, "Done",
                new ReceiveBankingInfo("AsiaBank", "Andrew Anderson", "9012345"),
                new ArrayList<String>() {{
                    add("f-9012345678_9012345678_Document1.pdf");
                    add("f-9012345678_9012345678_Document2.pdf");
                }});

        Claim claim10 = new Claim("f-0123456789", dateParser.parseDate("2024-04-10"), "Olivia Thomas", "0123 4567 8901 2345",
                dateParser.parseDate("2024-04-11"), 5500.00, "New",
                new ReceiveBankingInfo("AsiaBank", "Olivia Thomas", "0123456"),
                new ArrayList<String>() {{
                    add("f-0123456789_0123456789_Document1.pdf");
                    add("f-0123456789_0123456789_Document2.pdf");
                }});

        Claim claim11 = new Claim("f-1357924680", dateParser.parseDate("2024-04-11"), "James Lee", "1357 9246 8024 6801",
                dateParser.parseDate("2024-04-12"), 6000.00, "Processing",
                new ReceiveBankingInfo("AsiaBank", "James Lee", "1357246"),
                new ArrayList<String>() {{
                    add("f-1357924680_1357924680_Document1.pdf");
                    add("f-1357924680_1357924680_Document2.pdf");
                }});

        Claim claim12 = new Claim("f-2468013579", dateParser.parseDate("2024-04-12"), "Emma White", "2468 0135 7901 3579",
                dateParser.parseDate("2024-04-13"), 6500.00, "Done",
                new ReceiveBankingInfo("AsiaBank", "Emma White", "2468315"),
                new ArrayList<String>() {{
                    add("f-2468013579_2468013579_Document1.pdf");
                    add("f-2468013579_2468013579_Document2.pdf");
                }});

        Claim claim13 = new Claim("f-3579246801", dateParser.parseDate("2024-04-13"), "William Harris", "3579 2468 0135 7901",
                dateParser.parseDate("2024-04-14"), 7000.00, "New",
                new ReceiveBankingInfo("AsiaBank", "William Harris", "3579246"),
                new ArrayList<String>() {{
                    add("f-3579246801_3579246801_Document1.pdf");
                    add("f-3579246801_3579246801_Document2.pdf");
                }});

        Claim claim14 = new Claim("f-4680135792", dateParser.parseDate("2024-04-14"), "Ava Garcia", "4680 1357 9246 8013",
                dateParser.parseDate("2024-04-15"), 7500.00, "Processing",
                new ReceiveBankingInfo("AsiaBank", "Ava Garcia", "4681357"),
                new ArrayList<String>() {{
                    add("f-4680135792_4680135792_Document1.pdf");
                    add("f-4680135792_4680135792_Document2.pdf");
                }});

        Claim claim15 = new Claim("f-5792468013", dateParser.parseDate("2024-04-15"), "Daniel Wilson", "5792 4680 1357 9246",
                dateParser.parseDate("2024-04-16"), 8000.00, "Done",
                new ReceiveBankingInfo("AsiaBank", "Daniel Wilson", "5792468"),
                new ArrayList<String>() {{
                    add("f-5792468013_5792468013_Document1.pdf");
                    add("f-5792468013_5792468013_Document2.pdf");
                }});

        InsuranceCard card1 = new InsuranceCard("1234567", "John Doe", "John Doe", dateParser.parseDate("2024-12-31"));
        InsuranceCard card2 = new InsuranceCard("2345678", "Jane Smith", "Jane Smith", dateParser.parseDate("2024-12-31"));
        InsuranceCard card3 = new InsuranceCard("3456789", "David Johnson", "David Johnson", dateParser.parseDate("2024-12-31"));
        InsuranceCard card4 = new InsuranceCard("4567890", "Emily Brown", "Emily Brown", dateParser.parseDate("2024-12-31"));
        InsuranceCard card5 = new InsuranceCard("5678901", "Michael Davis", "Michael Davis", dateParser.parseDate("2024-12-31"));
        InsuranceCard card6 = new InsuranceCard("6789012", "Sarah Wilson", "Sarah Wilson", dateParser.parseDate("2024-12-31"));
        InsuranceCard card7 = new InsuranceCard("7890123", "Christopher Martinez", "Christopher Martinez", dateParser.parseDate("2024-12-31"));
        InsuranceCard card8 = new InsuranceCard("8901234", "Jessica Taylor", "Jessica Taylor", dateParser.parseDate("2024-12-31"));
        InsuranceCard card9 = new InsuranceCard("9012345", "Andrew Anderson", "Andrew Anderson", dateParser.parseDate("2024-12-31"));
        InsuranceCard card10 = new InsuranceCard("0123456", "Olivia Thomas", "Olivia Thomas", dateParser.parseDate("2024-12-31"));
        InsuranceCard card11 = new InsuranceCard("1357246", "James Lee", "James Lee", dateParser.parseDate("2024-12-31"));
        InsuranceCard card12 = new InsuranceCard("2468315", "Emma White", "Emma White", dateParser.parseDate("2024-12-31"));
        InsuranceCard card13 = new InsuranceCard("3579246", "William Harris", "William Harris", dateParser.parseDate("2024-12-31"));
        InsuranceCard card14 = new InsuranceCard("4681357", "Ava Garcia", "Ava Garcia", dateParser.parseDate("2024-12-31"));
        InsuranceCard card15 = new InsuranceCard("5792468", "Daniel Wilson", "Daniel Wilson", dateParser.parseDate("2024-12-31"));
        Customer customer1 = new Customer("c-1234567", "John Doe");
        Customer customer2 = new Customer("c-2345678", "Jane Smith");
        Customer customer3 = new Customer("c-3456789", "David Johnson");
        Customer customer4 = new Customer("c-4567890", "Emily Brown");
        Customer customer5 = new Customer("c-5678901", "Michael Davis");
        Customer customer6 = new Customer("c-6789012", "Sarah Wilson");
        Customer customer7 = new Customer("c-7890123", "Christopher Martinez");
        Customer customer8 = new Customer("c-8901234", "Jessica Taylor");
        Customer customer9 = new Customer("c-9012345", "Andrew Anderson");
        Customer customer10 = new Customer("c-0123456", "Olivia Thomas");
        Customer customer11 = new Customer("c-1357246", "James Lee");
        Customer customer12 = new Customer("c-2468315", "Emma White");
        Customer customer13 = new Customer("c-3579246", "William Harris");
        Customer customer14 = new Customer("c-4681357", "Ava Garcia");
        Customer customer15 = new Customer("c-5792468", "Daniel Wilson");
        CustomerManager customerManager=new CustomerManager();
        ClaimManager claimManager =new ClaimManager();
        claimManager.addClaim(claim1);
        claimManager.addClaim(claim2);
        claimManager.addClaim(claim3);
        claimManager.addClaim(claim4);
        claimManager.addClaim(claim5);
        claimManager.addClaim(claim6);
        claimManager.addClaim(claim7);
        claimManager.addClaim(claim8);
        claimManager.addClaim(claim9);
        claimManager.addClaim(claim10);
        claimManager.addClaim(claim11);
        claimManager.addClaim(claim12);
        claimManager.addClaim(claim13);
        claimManager.addClaim(claim14);
        claimManager.addClaim(claim15);
        customerManager.addCustomer(customer1);
        customerManager.addCustomer(customer2);
        customerManager.addCustomer(customer3);
        customerManager.addCustomer(customer4);
        customerManager.addCustomer(customer5);
        customerManager.addCustomer(customer6);
        customerManager.addCustomer(customer7);
        customerManager.addCustomer(customer8);
        customerManager.addCustomer(customer9);
        customerManager.addCustomer(customer10);
        customerManager.addCustomer(customer11);
        customerManager.addCustomer(customer12);
        customerManager.addCustomer(customer13);
        customerManager.addCustomer(customer14);
        customerManager.addCustomer(customer15);




        CustomerClaimHandler customerClaimHandler= new CustomerClaimHandler(customerManager,claimManager);
        UserActionHandler userActionHandler= new UserActionHandler(customerClaimHandler);
        userActionHandler.performAction();

    }
}
