import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public abstract class Customer {
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

    public CardHolder(String id, String fullName) {
        super(id, fullName);
    }
}

class Independent extends Customer {

    public Independent(String id, String fullName) {
        super(id, fullName);
    }
}
