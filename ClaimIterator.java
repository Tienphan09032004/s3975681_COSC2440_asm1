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