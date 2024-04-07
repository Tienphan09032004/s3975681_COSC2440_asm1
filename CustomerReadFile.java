import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomerReadFile {
    public static void readCustomersFromFile(String filename, CustomerManager customerManager) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 2) {
                    System.err.println("Invalid input format: " + line);
                    continue;
                }
                String id = parts[0].trim();
                String fullName = parts[1].trim();

                Customer customer = new CardHolder(id, fullName) {
                };

                customerManager.addCustomer(customer);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
