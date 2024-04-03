import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class ReceiveBankingCreator {
    ReceiveBankingInfo receiveBankingInfo;
    ReceiveBankingView view;

    public ReceiveBankingCreator(ReceiveBankingInfo receiveBankingInfo, ReceiveBankingView view) {
        this.receiveBankingInfo = receiveBankingInfo;
        this.view = view;
    }


    public void createBankingInfo() {
        Map<String, String> data = view.displayNewBankingInfoForm();
        String bankName = data.get(ReceiveBankingView.BANK_NAME);
        String accountNumber = data.get(ReceiveBankingView.ACCOUNT_NUMBER);
        String accountName = data.get(ReceiveBankingView.ACCOUNT_NAME);
        receiveBankingInfo.setBankName(bankName);
        receiveBankingInfo.setAccountNumber(accountNumber);
        receiveBankingInfo.setAccountName(accountName);
    }


}
