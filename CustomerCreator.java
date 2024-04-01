import java.util.Map;
import java.util.Scanner;

public class CustomerCreator {
    CustomerView view;

    public CustomerCreator(CustomerView view) {
        this.view = view;
    }

    public void eventLoop() {
        String answer = "Y";
        Scanner scanner = DataInput.getDataInput().getScanner();
        while (answer.equalsIgnoreCase("Y")) {
            Map<String, String> data = view.displayNewCustomerForm();
            String id = data.get(CustomerView.CUSTOMER_ID);
            String name = data.get(CustomerView.FULL_NAME);

            System.out.println("Nhập vai trò của bạn (CardHolder hoặc Independent):");
            String role = scanner.nextLine();

            Customer customer = null; // Khởi tạo customer ở đây

            if (role.equals("CardHolder")) {
                customer = new CardHolder(id, name);
            } else if (role.equals("Independent")) {
                customer = new Independent(id, name);
            } else {
                System.out.println("Vui lòng nhập lại vai trò (CardHolder hoặc Independent).");
                continue; // Tiếp tục vòng lặp nếu vai trò không hợp lệ
            }

            view.display(customer);

            System.out.println("Continue? ");
            answer = scanner.nextLine();
        }
    }
}