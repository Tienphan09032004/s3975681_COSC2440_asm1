import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class ReceiveBankingView {
    public static final String BANK_NAME="BANK_NAME";
    public static final String ACCOUNT_NAME="ACCOUNT_NAME";
    public static final String ACCOUNT_NUMBER="ACCOUNT_NUMBER";

    public abstract void display(ReceiveBankingInfo r);

    public abstract Map<String, String> displayNewBankingInfoForm();

}

class ReceiveBankingViewText extends ReceiveBankingView{

    @Override
    public void display(ReceiveBankingInfo r) {
        System.out.println("----------------------------");
        System.out.println("Bank name: " + r.getBankName());
        System.out.println("Account name: " + r.getAccountName());
        System.out.println("Account number: " + r.getAccountNumber());
        System.out.println("----------------------------");
        System.out.println();
    }

    @Override
    public Map<String, String> displayNewBankingInfoForm() {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> data = new HashMap<>();
        System.out.println("New Claim Form: ");
        System.out.println("Enter bank name: ");
        data.put(BANK_NAME, scanner.nextLine());
        System.out.println("Enter account name: ");
        data.put(ACCOUNT_NAME, scanner.nextLine());
        System.out.println("Enter account number: ");
        data.put(ACCOUNT_NUMBER, scanner.nextLine());
        return data;
    }
}
