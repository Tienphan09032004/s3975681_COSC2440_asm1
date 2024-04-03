
import java.util.*;

public abstract class ClaimView {

    public static final String CLAIM_ID = "CLAIM_ID";
    public static final String INSURED_PEOPLE = "INSURED_PEOPLE";
    public static final String CARD_NUMBER = "CARD_NUMBER";
    public static final String STATUS = "STATUS";
    public static final String CLAIM_DATE = "0000-00-00";
    public static final String CLAIM_AMOUNT = "0";
    public static final String EXAM_DATE = "0000/00/00";

    public abstract void display(Claim c);

    public abstract Map<String, String> displayNewClaimForm();

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
    public Map<String, String> displayNewClaimForm() {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> data = new HashMap<>();
        System.out.println("New Claim Form: ");
        System.out.println("Enter claim id: ");
        data.put(CLAIM_ID, scanner.nextLine());
        System.out.println("Enter claim date (YYYY-MM-DD): ");
        data.put(CLAIM_DATE, scanner.nextLine());
        System.out.println("Enter insured people: ");
        data.put(INSURED_PEOPLE, scanner.nextLine());
        System.out.println("Enter card number: ");
        data.put(CARD_NUMBER, scanner.nextLine());
        System.out.println("Enter exam date (YYYY-MM-DD): ");
        data.put(EXAM_DATE, scanner.nextLine());
        System.out.println("Enter claim amount: ");
        data.put(CLAIM_AMOUNT, scanner.nextLine());
        System.out.println("Enter status (New, Processing, Done): ");
        data.put(STATUS, scanner.nextLine());
        return data;
    }


}
