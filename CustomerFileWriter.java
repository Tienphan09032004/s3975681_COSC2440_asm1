import java.io.*;
import java.util.ArrayList;

public class CustomerFileWriter {

    public void rewriteFileWithCustomer(CustomerManager customerManager, String filePath) {

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filePath);
            writer.print(""); // Clear the file
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Write the claims to the file
        for (Customer customer : customerManager.getCustomers()) {
            writeTripToFile(customer, filePath);
        }
    }

    public void writeTripToFile(Customer customer, String filePath) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));

            writer.write(String.valueOf(customer));
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

