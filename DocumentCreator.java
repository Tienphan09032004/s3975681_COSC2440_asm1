import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DocumentCreator {
    private static final Scanner scanner = DataInput.getDataInput().getScanner();

    public static ArrayList<String> createDocuments() {
        ArrayList<String> documents = new ArrayList<>();
        while (true) {
            System.out.println("Enter document name (format: ClaimId_CardNumber_DocumentName.pdf): ");
            String documentName = scanner.nextLine().trim();



            documents.add(documentName);

            System.out.println("Do you want to add another document? (yes/no): ");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (!choice.equals("yes")) {
                break;
            }
        }
        return documents;
    }


}
