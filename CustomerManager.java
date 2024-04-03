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
}