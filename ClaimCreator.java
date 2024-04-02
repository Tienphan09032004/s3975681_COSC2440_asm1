import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class ClaimCreator {
    ClaimView view;

    public ClaimCreator(ClaimView view) {
        this.view = view;
    }

    public void createCustomer() {
        String answer = "Y";
        Scanner scanner = DataInput.getDataInput().getScanner();
        while (answer.equalsIgnoreCase("Y")) {
            Map<String, Object> data = view.displayNewClaimForm();
            String id = (String) data.get(ClaimView.CLAIM_ID);
            String insured_people = (String) data.get(ClaimView.INSURED_PEOPLE);
            double claim_amount = (double) data.get(ClaimView.CLAIM_AMOUNT);
            Date claim_date = parseDate((String) data.get(ClaimView.CLAIM_DATE));

            String status = (String) data.get(ClaimView.STATUS);
            String card_number = (String) data.get(ClaimView.CARD_NUMBER);

            // Convert the Date object to String before storing in the map
            String exam_date_str = (String) data.get(ClaimView.EXAM_DATE);
            Date exam_date = parseDate(exam_date_str);
            Claim claim = new Claim(id,claim_date,insured_people,card_number,exam_date,claim_amount,status);
            // Continue with the rest of your code
            System.out.println("Continue? ");
            answer = scanner.nextLine();
        }
    }

    private Date parseDate(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(dateString);
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
            return null;
        }
    }
}