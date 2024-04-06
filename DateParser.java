import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;


public class DateParser {
    private static final String[] DATE_FORMATS = {
            "yyyy-MM-dd"
    };

    public Date parseDate(String dateString) {
        for (String format : DATE_FORMATS) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat(format);
                dateFormat.setLenient(false);
                return dateFormat.parse(dateString);
            } catch (ParseException e) {
                // skip
            }
        }
        System.out.println("Invalid date format. Please enter date in one of the supported formats.");
        return null;
    }
}
