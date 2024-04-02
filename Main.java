public class Main {
    public static void main(String args[]) {

        ClaimCreator controller = new ClaimCreator(new ClaimViewText());
        controller.createCustomer();
    }
}