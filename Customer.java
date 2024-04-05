import java.util.ArrayList;

public abstract class Customer {
    private String id;
    private String fullName;

    private InsuranceCard insuranceCard;
    private ArrayList<Claim> claims;

    public Customer(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
        this.claims = new ArrayList<>();
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

    public ArrayList<Claim> getClaims() {
        return claims;
    }

    public void addClaim(Claim claim) {
        this.claims.add(claim);
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


