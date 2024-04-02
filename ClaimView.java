import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class ClaimView {

    public static final String CLAIM_ID = "CLAIM_ID";
    public static final String INSURED_PEOPLE = "INSURED_PEOPLE";
    public static final String CARD_NUMBER = "CARD_NUMBER";
    public static final String STATUS = "STATUS";
    public static final Date CLAIM_DATE = new Date();
    public static final double CLAIM_AMOUNT = 0.0; // Initialize to 0.0
    public static final Date EXAM_DATE = new Date();

    public abstract void display(Claim c);

    public abstract Map<String, Object> displayNewClaimForm();

}


class ClaimViewText extends ClaimView {

    @Override
    public void display(Claim claim) {
        System.out.println("----------------------------");
        System.out.println("Claim ID: " + claim.getId());
        System.out.println("Claim Date: " + claim.getClaimDate());
        System.out.println("Insured People: " + claim.getInsuredPeople());
        System.out.println("Card Number: " + claim.getCardNumber());
        System.out.println("Exam Date: " + claim.getExamDate());
        System.out.println("Claim Amount: " + claim.getClaimAmount());
        System.out.println("Status: " + claim.getStatus());
        System.out.println("----------------------------");
        System.out.println();
    }

    @Override
    public Map<String, Object> displayNewClaimForm() {
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> data = new HashMap<>();
        System.out.println("New Claim Form: ");
        System.out.println("Enter claim id: ");
        data.put(CLAIM_ID, scanner.nextLine());
        System.out.println("Enter claim date (YYYY-MM-DD): ");
        String claimDateString = scanner.nextLine();
        Date claimDate = parseDate(claimDateString);
        data.put(String.valueOf(CLAIM_DATE), claimDate);
        System.out.println("Enter insured people: ");
        data.put(INSURED_PEOPLE, scanner.nextLine());
        System.out.println("Enter card number: ");
        data.put(CARD_NUMBER, scanner.nextLine());
        System.out.println("Enter exam date (YYYY-MM-DD): ");
        String examDateString = scanner.nextLine();
        Date examDate = parseDate(examDateString);
        data.put(String.valueOf(EXAM_DATE), examDate);
        System.out.println("Enter claim amount: ");
        double claimAmount = scanner.nextDouble();
        data.put(String.valueOf(CLAIM_AMOUNT), claimAmount);
        System.out.println("Enter status (New, Processing, Done): ");
        data.put(STATUS, scanner.nextLine());
        return data;
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
