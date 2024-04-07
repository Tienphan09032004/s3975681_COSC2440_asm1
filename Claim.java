import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Claim {
    private String id;
    private Date claimDate;
    private String insuredPeople;
    private String cardNumber;
    private Date examDate;
    private ArrayList<String> documents;
    private String status;
    private double claimAmount;
    private ReceiveBankingInfo receiveBankingInfo;
    private Scanner scanner;

    public Claim(String id, Date claimDate, String insuredPeople, String cardNumber, Date examDate, double claimAmount,String status, ReceiveBankingInfo receiveBankingInfo,  ArrayList<String> documents) {
        setId(id);;
        this.claimDate = claimDate;
        this.insuredPeople = insuredPeople;
        setCardNumber(cardNumber);;
        this.examDate = examDate;
        this.claimAmount = claimAmount;
        setStatus(status);
        this.receiveBankingInfo = receiveBankingInfo;
        setDocuments(documents);
    }

    public Claim() {
        this.scanner = new Scanner(System.in);
        this.id = "null";
        this.claimDate = null;
        this.insuredPeople = "null";
        this.cardNumber = "null";
        this.examDate = null;
        this.documents = null;
        this.claimAmount = 0;
        this.receiveBankingInfo = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (isValidID(id)) {
            this.id = id;
        } else {
            System.out.println("Invalid ID format. Please enter again (with the format f-numbers; 10 numbers) :");
            setId(scanner.nextLine());
        }
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public String getInsuredPeople() {
        return insuredPeople;
    }

    public void setInsuredPeople(String insuredPeople) {
        this.insuredPeople = insuredPeople;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        if (isValidCardNumber(cardNumber)) {
            this.cardNumber = cardNumber;
        } else {
            System.out.println("Invalid card number format. Please enter again (10 digits):");
            setCardNumber(scanner.nextLine());
        }
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public ArrayList<String> getDocuments() {
        return documents;
    }

    public void setDocuments(ArrayList<String> documents) {
        if (isValidDocuments(documents)) {
            this.documents = documents;
        } else {
            System.out.println("Invalid document format. Please enter again:  (with the format ClaimId_CardNumber_DocumentName.pdf) ");
            setDocuments(new ArrayList<>());
        }
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public ReceiveBankingInfo getReceiveBankingInfo() {
        return receiveBankingInfo;
    }

    public void setReceiveBankingInfo(ReceiveBankingInfo receiveBankingInfo) {
        this.receiveBankingInfo = receiveBankingInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String lowercaseStatus = status.toLowerCase();
        if (isValidStatus(lowercaseStatus)) {
            this.status = lowercaseStatus;
        } else {
            System.out.println("Invalid status. Please enter again (New, Processing, Done):");
            this.status = scanner.nextLine();
            setStatus(this.status);
        }
    }

    private boolean isValidStatus(String status) {
        return status != null && (status.equals("new") || status.equals("processing") || status.equals("done"));
    }

    private boolean isValidID(String id) {
        return id != null && id.matches("f-\\d{10}");
    }

    private boolean isValidCardNumber(String cardNumber) {

        return cardNumber != null && cardNumber.matches("\\d{10}");
    }

    private boolean isValidDocuments(ArrayList<String> documents) {
        for (String document : documents) {
            if (!document.matches("f-\\d{10}_\\d{10}_\\w+\\.pdf")) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Claim claim = (Claim) obj;
        return Objects.equals(id, claim.id);
    }

    @Override
    public String toString() {
        return "Claim{" +
                "id='" + id + '\'' +
                ", claimDate=" + claimDate +
                ", insuredPeople='" + insuredPeople + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", examDate=" + examDate +
                ", documents=" + documents +
                ", status='" + status + '\'' +
                ", claimAmount=" + claimAmount +
                ", receiveBankingInfo=" + receiveBankingInfo +
                '}';
    }
}
