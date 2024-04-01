import java.util.ArrayList;

public abstract class Customer {
    private String id;
    private String fullName;

    private InsuranceCard insuranceCard;
    private ArrayList<Claim> claims;

    public Customer(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
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
}
class CardHolder extends Customer{
    private ArrayList<Independent> independents;


    public CardHolder(String id, String fullName) {
        super(id, fullName);
    }
}

class Independent extends Customer{
    private CardHolder cardHolder;


    public Independent(String id, String fullName) {
        super(id, fullName);
    }
}

