import java.util.ArrayList;
import java.util.HashSet;

public abstract class Customer {
    private String id;
    private String fullName;

    private InsuranceCard insuranceCard;
    private HashSet<Claim> claims;

    public Customer(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
        this.claims = new HashSet<>();
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

    public HashSet<Claim> getClaims() {
        return claims;
    }

    public void addClaim(Claim claim) {
        this.claims.add(claim);
    }

    public HashSet<Claim> getAllClaims() {
        return claims;
    }

    public boolean removeClaim(Claim claim) {
        return this.claims.remove(claim);
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


