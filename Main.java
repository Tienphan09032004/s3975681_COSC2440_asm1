public class Main {
    public static void main(String args[]) {


        ClaimCreator controller = new ClaimCreator(new Claim(), new ClaimViewText());
        controller.createCustomer();
    }
}