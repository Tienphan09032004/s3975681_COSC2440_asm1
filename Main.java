public class Main {
    public static void main(String args[]) {
        CustomerManager customerManager = new CustomerManager();
        CustomerCreator controller = new CustomerCreator(new CustomerViewText());
        controller.createCustomer(customerManager);
    }
}