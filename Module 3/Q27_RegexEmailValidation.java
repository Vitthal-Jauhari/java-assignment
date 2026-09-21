// Q27: Regular Expressions using Pattern and Matcher to validate email addresses.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q27_RegexEmailValidation {
    // Standard RFC-compliant or general practical email regex pattern
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX);

    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        Matcher matcher = PATTERN.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] testEmails = {
            "student@university.edu",
            "john.doe@example.com",
            "vitthal123@gmail.com",
            "invalid-email@",
            "user@domain",
            "@missingusername.com",
            "user@sub.domain.org"
        };

        System.out.println("Email Validation using java.util.regex:");
        System.out.println("----------------------------------------");
        for (String email : testEmails) {
            boolean valid = isValidEmail(email);
            System.out.printf("%-30s -> %s%n", email, (valid ? "VALID" : "INVALID"));
        }
    }
}
