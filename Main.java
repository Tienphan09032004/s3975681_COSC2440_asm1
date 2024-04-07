import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager();
        String cusFile = "customers.txt";
        CustomerReadFile.readCustomersFromFile(cusFile, customerManager);
        String claimFile= "claims.txt";
        ClaimReadFile claimReader = new ClaimReadFile();
        ClaimManager claimManager = new ClaimManager(claimReader.readClaimsFromFile(claimFile));

        InsuranceCardManager insuranceCardManager = new InsuranceCardManager();
        String ICFile = "insurance_cards.txt";
        insuranceCardManager = InsuranceCardReadFile.readInsuranceCardsFromFile(ICFile);
        for (Customer customer : customerManager.getCustomers()) {
            // Kiểm tra nếu tên đầy đủ của khách hàng trùng với cardHolder của thẻ bảo hiểm
            if (customer.getFullName().equals(insuranceCardManager.getInsuranceCards().iterator().next().getCardHolder())) {
                // Cập nhật thông tin thẻ bảo hiểm thành "Insured Card"


                customer.setInsuranceCard(insuranceCardManager.getInsuranceCards().iterator().next());
            }
        }
        System.out.println(claimManager);
        ClaimFileWriter claimFileWriter = new ClaimFileWriter();
        claimFileWriter.rewriteFileWithClaims(claimManager,claimFile);
        CustomerFileWriter customerFileWriter = new CustomerFileWriter();
        customerFileWriter.rewriteFileWithCustomer(customerManager,cusFile);


    }


}
