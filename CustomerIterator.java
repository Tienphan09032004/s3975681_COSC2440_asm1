import java.util.Iterator;

public class CustomerIterator implements Iterator<Customer> {
    private Iterator<Customer> iterator;

    public CustomerIterator(Iterator<Customer> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Customer next() {
        return iterator.next();
    }

    // Optional: Implement the remove method if needed
    @Override
    public void remove() {
        iterator.remove();
    }

    // Custom method to find a customer by ID
    public Customer findCustomerById(String id) {
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.getId().equals(id) ) {
                return customer;
            }
        }
        return null;
    }
}

