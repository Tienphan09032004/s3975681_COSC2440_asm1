import java.util.HashSet;

public class CustomerManager {
    private final HashSet<Customer> customers;

    public CustomerManager(HashSet<Customer> customers) {
        this.customers = customers;
    }


    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public HashSet<Customer> getCustomers() {
        return customers;
    }

    public Customer findCustomerById(String id) {
        CustomerIterator customerIterator = new CustomerIterator(customers.iterator());
        return customerIterator.findCustomerById(id);
    }

    public Customer findCustomerByClaim(Claim claim) {
        for (Customer customer : customers) {
            if (customer.getClaims().contains(claim)) {
                return customer;
            }
        }
        return null;
    }

    public void updateCustomer(Customer customer) {
        // Check if a customer with the same ID already exists
        Customer existingCustomer = findCustomerById(customer.getId());

        // If an existing customer is found, remove it
        if (existingCustomer != null) {
            customers.remove(existingCustomer);
        }

        // Add the new customer
        customers.add(customer);
    }

    @Override
    public String toString() {
        return "CustomerManager{" +
                "customers=" + customers +
                '}';
    }
}