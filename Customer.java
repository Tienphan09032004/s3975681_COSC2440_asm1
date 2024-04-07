import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public  class Customer {
    private String id;
    private String fullName;

    private InsuranceCard insuranceCard;
    private ClaimManager claims;

    public Customer(String id, String fullName) {
        if (isValidID(id)) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("Invalid ID format. The ID must be in the format c-xxxxxxx.");
        }
        this.fullName = fullName;
        this.claims = new ClaimManager();
    }

    private boolean isValidID(String id) {
        return id != null && id.matches("c-\\d{7}");
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public InsuranceCard getInsuranceCard() {
        return insuranceCard;
    }

    public ClaimManager getClaims() {
        return claims;
    }

    public void addClaim(Claim claim) {
        this.claims.addClaim(claim);
    }

    public boolean removeClaim(Claim claim) {
        return this.claims.deleteClaim(claim);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setInsuranceCard(InsuranceCard insuranceCard) {
        this.insuranceCard = insuranceCard;
    }

    public void setClaims(ClaimManager claims) {
        this.claims = claims;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Customer customer = (Customer) obj;
        return Objects.equals(id, customer.id);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", insuranceCard=" + insuranceCard +
                ", claims=" + claims +
                '}';
    }
}

class CardHolder extends Customer {

    HashSet<Independent> independents;

    public CardHolder(String id, String fullName) {
        super(id, fullName);
    }

    public CardHolder(String id, String fullName, HashSet<Independent> independents) {
        super(id, fullName);
        this.independents= independents;
    }

    public HashSet<Independent> getIndependents() {
        return independents;
    }

    public void setIndependents(HashSet<Independent> independents) {
        this.independents = independents;
    }

    public void addIndependents(Independent independent) {
        this.independents.add(independent);
    }


}

class Independent extends Customer {

    CardHolder cardHolder;

    public Independent(String id, String fullName) {
        super(id, fullName);
    }

    public Independent(String id, String fullName, CardHolder cardHolder) {
        super(id, fullName);
        this.cardHolder=cardHolder;
    }

    public CardHolder getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(CardHolder cardHolder) {
        this.cardHolder = cardHolder;
    }
}
