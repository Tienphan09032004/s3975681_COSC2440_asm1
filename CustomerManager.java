import java.util.HashSet;

public class CustomerManager {
    private HashSet<Customer> customerList;

    public CustomerManager(HashSet<Customer> customerList) {
        this.customerList = customerList;
    }

    public CustomerManager() {
        this.customerList= new HashSet<>();
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }
    @Override
    public String toString() {
        return "CustomerManager{" +
                "customerList=" + customerList +
                '}';
    }
}
