import java.io.*;
import java.util.ArrayList;

public class ClaimFileWriter {

    public void rewriteFileWithClaims(ClaimManager claimManager, String filePath) {

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filePath);
            writer.print(""); // Clear the file
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Write the claims to the file
        for (Claim claim : claimManager.getAllClaims()) {
            writeTripToFile(claim, filePath);
        }
    }

    public void writeTripToFile(Claim claim, String filePath) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));

            writer.write(String.valueOf(claim));
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
