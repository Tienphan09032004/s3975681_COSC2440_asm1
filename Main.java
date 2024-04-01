public class Main {
    public static void main(String args[]) {
        CustomerCreator controller = new CustomerCreator(new CustomerViewText());
        controller.eventLoop();
    }
}