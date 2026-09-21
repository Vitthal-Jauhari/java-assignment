// Q26: Using java.util.Date and java.util.Calendar to display current date and time.

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Q26_DateCalendarDemo {
    public static void main(String[] args) {
        // Using java.util.Date
        Date currentDate = new Date();
        System.out.println("--- Using java.util.Date ---");
        System.out.println("Current Date and Time: " + currentDate);

        // Formatting with SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Formatted Date: " + sdf.format(currentDate));

        // Using java.util.Calendar
        Calendar calendar = Calendar.getInstance();
        System.out.println("\n--- Using java.util.Calendar ---");
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // Months are 0-indexed
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        System.out.println("Year   : " + year);
        System.out.println("Month  : " + month);
        System.out.println("Day    : " + day);
        System.out.println("Time   : " + String.format("%02d:%02d:%02d", hour, minute, second));
        System.out.println("Timezone: " + calendar.getTimeZone().getID());
    }
}
