public class ReceiveBankingInfo {
    private String bankName;
    private String accountName;
    private String accountNumber;

    public ReceiveBankingInfo(String bankName, String accountName, String accountNumber) {
        this.bankName = bankName;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
    }

    public ReceiveBankingInfo() {
        this.bankName = "null";
        this.accountName = "null";
        this.accountNumber = "null";
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "ReceiveBankingInfo{" +
                "bankName='" + bankName + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}'+'\'';
    }
}
