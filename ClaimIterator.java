import java.util.Iterator;

public class ClaimIterator implements Iterator<Claim> {
    private Iterator<Claim> iterator;

    public ClaimIterator(Iterator<Claim> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Claim next() {
        return iterator.next();
    }

    // Optional: Implement the remove method if needed
    @Override
    public void remove() {
        iterator.remove();
    }

    public Claim findCustomerById(String id) {
        while (iterator.hasNext()) {
            Claim claim = iterator.next();
            if (claim.getId().equals(id) ) {
                return claim;
            }
        }
        return null;
    }
}