import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsuranceCardReadFile {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static InsuranceCardManager readInsuranceCardsFromFile(String filename) {
        InsuranceCardManager insuranceCardManager = new InsuranceCardManager();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 4) {
                    System.err.println("Invalid input format: " + line);
                    continue;
                }
                String cardNumber = parts[0].trim();
                if (cardNumber.length() != 10 || !cardNumber.matches("\\d{10}")) {
                    System.err.println("Invalid card number format: " + cardNumber);
                    continue;
                }
                String cardHolder = parts[1].trim();
                String policyOwner = parts[2].trim();
                Date expirationDate = parseDate(parts[3].trim());

                InsuranceCard insuranceCard = new InsuranceCard(cardNumber, cardHolder, policyOwner, expirationDate);
                insuranceCardManager.addInsuranceCard(insuranceCard);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return insuranceCardManager;
    }

    private static Date parseDate(String dateString) {
        try {
            return DATE_FORMAT.parse(dateString);
        } catch (ParseException e) {
            System.err.println("Error parsing date: " + dateString);
            return null;
        }
    }
}
