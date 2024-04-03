import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class ClaimCreator {
    Claim claim;
    ClaimView view;

    public ClaimCreator(Claim claim, ClaimView view) {
        this.claim = claim;
        this.view = view;
    }
    private static final ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public void createCustomer() {
        String answer = "Y";
        Scanner scanner = new Scanner(System.in);
        while (answer.equalsIgnoreCase("Y")) {
            Map<String, String> data = view.displayNewClaimForm();
            String id = data.get(ClaimView.CLAIM_ID);
            String insured_people = data.get(ClaimView.INSURED_PEOPLE);
            double claim_amount = Double.parseDouble(data.get(ClaimView.CLAIM_AMOUNT));
            Date claim_date = parseDate(data.get(ClaimView.CLAIM_DATE));
            String status = data.get(ClaimView.STATUS);
            String card_number = data.get(ClaimView.CARD_NUMBER);
            Date exam_date = parseDate(data.get(ClaimView.EXAM_DATE));
            if (claim_date != null && exam_date != null) {
                Claim claim = new Claim(id, claim_date, insured_people, card_number, exam_date, claim_amount, status);
                view.display(claim);
            } else {
                System.out.println("Invalid date format. Please enter dates in YYYY-MM-DD format.");
            }
            System.out.println("Continue? (Y/N)");
            answer = scanner.nextLine();
        }
    }

    private Date parseDate(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
            return null;
        }
    }
}
