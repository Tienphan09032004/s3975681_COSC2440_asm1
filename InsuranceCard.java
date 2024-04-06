import java.util.Date;

public class InsuranceCard {
    private String id;
    private String cardHolder;
    private String policyHolder;
    private Date expiredDate;

    public InsuranceCard(String id, String cardHolder, String policyHolder, Date expiredDate) {
        this.id = id;
        this.cardHolder = cardHolder;
        this.policyHolder = policyHolder;
        this.expiredDate = expiredDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(String policyHolder) {
        this.policyHolder = policyHolder;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Override
    public String toString() {
        return "InsuranceCard{" +
                "id='" + id + '\'' +
                ", cardHolder='" + cardHolder + '\'' +
                ", policyHolder='" + policyHolder + '\'' +
                ", expiredDate=" + expiredDate +
                '}';
    }
}
