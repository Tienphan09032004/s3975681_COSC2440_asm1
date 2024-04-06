import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ClaimManager {
    private final HashSet<Claim> claims;

    public ClaimManager() {
        this.claims = new HashSet<>();
    }

    public ClaimManager(HashSet<Claim> claims) {
        this.claims = claims;
    }


    public void addClaim(Claim claim) {
        if (!claims.contains(claim)) {
            claims.add(claim);
        } else {
            System.out.println("Claim with ID " + claim.getId() + " already exists. Cannot add duplicate claim.");
        }
    }


    public HashSet<Claim> getClaims() {
        return claims;
    }

    public boolean deleteClaim(Claim claim) {
        claims.remove(claim);
        return true;
    }

    public Claim findClaimById(String id) {
        ClaimIterator claimIterator = new ClaimIterator(claims.iterator());
        return claimIterator.findCustomerById(id);
    }

    public List<Claim> getAllClaims() {
        return new ArrayList<>(claims);
    }

    public void updateClaim(Claim updatedClaim) {
        for (Claim claim : claims) {
            if (claim.getId().equals(updatedClaim.getId())) {
                claim.setClaimDate(updatedClaim.getClaimDate());
                claim.setInsuredPeople(updatedClaim.getInsuredPeople());
                claim.setCardNumber(updatedClaim.getCardNumber());
                claim.setExamDate(updatedClaim.getExamDate());
                claim.setDocuments(updatedClaim.getDocuments());
                claim.setStatus(updatedClaim.getStatus());
                claim.setClaimAmount(updatedClaim.getClaimAmount());
                claim.setReceiveBankingInfo(updatedClaim.getReceiveBankingInfo());
                return;
            }
        }
    }
    @Override
    public String toString() {
        return "ClaimManager{" +
                "claims=" + claims +
                '}';
    }
}
