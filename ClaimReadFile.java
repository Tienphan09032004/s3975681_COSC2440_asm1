import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ClaimReadFile {

    private SimpleDateFormat formater = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

    public HashSet<Claim> readClaimsFromFile(String filePath) {
        HashSet<Claim> claims = new HashSet<>();
        File file = new File(filePath);

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                Claim claim = readClaim(scanner);
                if (claim != null) {
                    // Kiểm tra xem claim đã tồn tại trong HashSet chưa trước khi thêm vào
                    if (!claims.contains(claim)) {
                        claims.add(claim);
                    } else {
                        System.out.println("Claim already exists: " + claim.getId());
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: File not found.");
            e.printStackTrace();
        }

        return claims;
    }

    public boolean isFileEmpty(String filePath) {
        File file = new File(filePath);
        return file.length() == 0;
    }

    private Claim readClaim(Scanner scanner) {
        String id = "";
        Date claimDate = null;
        String insuredPerson = "";
        String cardNumber = "";
        Date examDate = null;
        ArrayList<String> documents = new ArrayList<>();
        double claimAmount = 0;
        String status = null;
        ReceiveBankingInfo receiveBankingInfo = null;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("-----------------------------------")) {
                break;
            }

            String[] parts = line.split(": ");
            // Kiểm tra kích thước của mảng parts trước khi truy cập vào phần tử thứ hai
            if (parts.length >= 2) {
                String key = parts[0];
                String value = parts[1];

                try {
                    switch (key) {
                        case "Claim ID":
                            id = value;
                            break;
                        case "Claim Date":
                            claimDate = formater.parse(value);
                            break;
                        case "Insured person":
                            insuredPerson = value;
                            break;
                        case "Card number":
                            cardNumber = value;
                            break;
                        case "Exam Date":
                            examDate = formater.parse(value);
                            break;
                        case "Documents":
                            documents.addAll(Arrays.asList(value.substring(1, value.length() - 1).split(", ")));
                            break;
                        case "Claim Amount":
                            claimAmount = Double.parseDouble(value);
                            break;
                        case "Claim Status":
                            status = value;
                            break;
                        case "Banking info":
                            String[] bankingInfoParts = value.split(" – ");
                            // Kiểm tra kích thước của mảng bankingInfoParts trước khi truy cập vào phần tử thứ hai
                            if (bankingInfoParts.length >= 3) {
                                receiveBankingInfo = new ReceiveBankingInfo(bankingInfoParts[0], bankingInfoParts[1], bankingInfoParts[2]);
                            } else {
                                System.out.println("Banking info format is incorrect: " + line);
                            }
                            break;
                    }
                } catch (ParseException e) {
                    System.out.println("An error occurred while parsing the date.");
                    e.printStackTrace();
                }
            } else {
                // In ra thông báo và dòng không đúng
                System.out.println("Line format is incorrect: " + line);
            }
        }

        return new Claim(id, claimDate, insuredPerson, cardNumber, examDate, claimAmount, status, receiveBankingInfo, documents);
    }


}
