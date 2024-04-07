import java.util.Date;

public class InsuranceCard {
    private String cardNumber;
    private String cardHolder;
    private String policyOwner;
    private Date expirationDate;

    public InsuranceCard(String cardNumber, String cardHolder, String policyOwner, Date expirationDate) {
        if (!isValidCardNumber(cardNumber)) {
            throw new IllegalArgumentException("Card number must contain exactly 7 digits.");
        }
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.policyOwner = policyOwner;
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        if (!isValidCardNumber(cardNumber)) {
            throw new IllegalArgumentException("Card number must contain exactly 7 digits.");
        }
        this.cardNumber = cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getPolicyOwner() {
        return policyOwner;
    }

    public void setPolicyOwner(String policyOwner) {
        this.policyOwner = policyOwner;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    private boolean isValidCardNumber(String cardNumber) {
        return cardNumber != null && cardNumber.matches("\\d{7}");
    }

    @Override
    public String toString() {
        return "InsuranceCard{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cardHolder='" + cardHolder + '\'' +
                ", policyOwner='" + policyOwner + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
