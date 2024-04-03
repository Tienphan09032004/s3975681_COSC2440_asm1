import java.util.ArrayList;
import java.util.Date;

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

    public Claim(String id, Date claimDate, String insuredPeople, String cardNumber, Date examDate, ArrayList<String> documents, double claimAmount, ReceiveBankingInfo receiveBankingInfo) {
        this.id = id;
        this.claimDate = claimDate;
        this.insuredPeople = insuredPeople;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.documents = documents;
        this.claimAmount = claimAmount;
        this.receiveBankingInfo = receiveBankingInfo;
    }

    public Claim(String id, Date claimDate, String insuredPeople, String cardNumber, Date examDate, double claimAmount, String status) {
        this.id = id;
        this.claimDate = claimDate;
        this.insuredPeople = insuredPeople;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.claimAmount = claimAmount;
        this.status= status;
    }

    public Claim() {
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
        this.id = id;
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
        this.cardNumber = cardNumber;
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
        this.documents = documents;
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
        this.status = status;
    }
}
