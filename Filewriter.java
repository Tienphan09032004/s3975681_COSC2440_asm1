import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Filewriter {
    private static final String FILE_PATH = "claims.txt"; // Change the file path as needed

    public void writeClaimToFile(Claim claim) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            String claimData = claim.getId() + "," +
                    claim.getClaimDate() + "," +
                    claim.getInsuredPeople() + "," +
                    claim.getCardNumber() + "," +
                    claim.getExamDate() + "," +
                    claim.getStatus() + "," +
                    claim.getClaimAmount() + "\n";
            writer.write(claimData);
            System.out.println("Claim data has been written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing claim data to file: " + e.getMessage());
        }
    }

    public void writeClaimsToFile(ArrayList<Claim> claims) {
        for (Claim claim : claims) {
            writeClaimToFile(claim);
        }
    }
}
