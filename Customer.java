import java.util.ArrayList;

public abstract class Customer {
    private String id;
    private String fullName;

    private InsuranceCard insuranceCard;
    private ArrayList<Claim> claims;


}
class CardHolder extends Customer{
    private ArrayList<Independent> independents;

}

class Independent extends Customer{
    private CardHolder cardHolder;


}