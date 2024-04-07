import java.util.ArrayList;
import java.util.List;

public class InsuranceCardManager {
    private List<InsuranceCard> insuranceCards;

    public InsuranceCardManager() {
        this.insuranceCards = new ArrayList<>();
    }

    public void addInsuranceCard(InsuranceCard insuranceCard) {
        insuranceCards.add(insuranceCard);
    }

    public List<InsuranceCard> getInsuranceCards() {
        return insuranceCards;
    }

    public void setInsuranceCards(List<InsuranceCard> insuranceCards) {
        this.insuranceCards = insuranceCards;
    }

    // Add any additional methods as needed

    @Override
    public String toString() {
        return "InsuranceCardManager{" +
                "insuranceCards=" + insuranceCards +
                '}';
    }
}
