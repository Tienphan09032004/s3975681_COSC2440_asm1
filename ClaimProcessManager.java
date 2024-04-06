import java.util.List;

public interface ClaimProcessManager {
    // Add a claim to the list
    void add();

    // Delete a claim from the list
    void delete();


    // Update an existing claim
    void update();


    // Get a specific claim by ID
    Claim getOne();

    // Get all claims
    List<Claim> getAll();
}