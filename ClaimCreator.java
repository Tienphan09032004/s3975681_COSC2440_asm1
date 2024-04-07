import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class ClaimCreator {
    Claim claim;
    ClaimView view;

    Filewriter filewriter = new Filewriter();

    public ClaimCreator(Claim claim, ClaimView view, Filewriter filewriter) {
        this.claim = claim;
        this.view = view;
        this.filewriter= filewriter;
    }

    DateParser dateParser= new DateParser();
    public Claim createClaim() {
        Scanner scanner = DataInput.getDataInput().getScanner();
            Map<String, String> data = view.displayNewClaimForm();
            String id = data.get(ClaimView.CLAIM_ID);
            String insured_people = data.get(ClaimView.INSURED_PEOPLE);
            double claim_amount = Double.parseDouble(data.get(ClaimView.CLAIM_AMOUNT));
            Date claim_date = null;
            ArrayList<String> documents = DocumentCreator.createDocuments();
            while (claim_date == null) {
                String claimDateStr = data.get(ClaimView.CLAIM_DATE);
                claim_date = dateParser.parseDate(claimDateStr);
                if (claim_date == null) {
                    System.out.println("Invalid claim date format. Please enter date in one of the supported formats.");
                    System.out.print("Enter claim date (YYYY-MM-DD): ");
                    claimDateStr = scanner.nextLine();
                    data.put(ClaimView.CLAIM_DATE, claimDateStr);
                }
            }
            String status = data.get(ClaimView.STATUS);
            String card_number = data.get(ClaimView.CARD_NUMBER);
            Date exam_date = null;
            while (exam_date == null) {
                String exam_dateStr = data.get(ClaimView.EXAM_DATE);
                exam_date = dateParser.parseDate(exam_dateStr);
                if (exam_date == null) {
                    System.out.println("Invalid claim date format. Please enter date in one of the supported formats.");
                    System.out.print("Enter claim date (YYYY-MM-DD): ");
                    exam_dateStr = scanner.nextLine();
                    data.put(ClaimView.EXAM_DATE, exam_dateStr);
                }
            }
            ReceiveBankingInfo receiveBankingInfo= new ReceiveBankingInfo();
            ReceiveBankingViewText receiveBankingViewText= new ReceiveBankingViewText();
            ReceiveBankingCreator receiveBankingCreator = new ReceiveBankingCreator(receiveBankingInfo ,receiveBankingViewText);
            receiveBankingCreator.createBankingInfo();
            filewriter.writeClaimToFile(new Claim(id, claim_date, insured_people, card_number, exam_date, claim_amount, status, receiveBankingInfo, documents));
            return new Claim(id,claim_date,insured_people,card_number,exam_date, claim_amount,status,receiveBankingInfo, documents);

    }



}
