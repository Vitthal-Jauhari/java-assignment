// Q10: User Input Validation Engine combining multiple custom annotations (@NotNull, @MinLength, @EmailPattern).

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

// 1. @NotNull Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotNull {
    String message() default "Field must not be null.";
}

// 2. @Length Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface StringRange {
    int min() default 0;
    int max() default Integer.MAX_VALUE;
    String message() default "String length out of valid range.";
}

// 3. @EmailPattern Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface EmailPattern {
    String message() default "Invalid email address format.";
}

// User Profile Model with Annotations
class UserProfile {
    @NotNull(message = "Username cannot be null.")
    @StringRange(min = 4, max = 20, message = "Username must be between 4 and 20 characters.")
    private String username;

    @NotNull(message = "Email cannot be null.")
    @EmailPattern(message = "Please provide a valid email format.")
    private String email;

    @StringRange(min = 6, max = 50, message = "Password must be at least 6 characters.")
    private String password;

    public UserProfile(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}

// Validation Engine
class InputValidator {
    private static final Pattern EMAIL_REGEX = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public static List<String> validate(Object target) {
        List<String> errors = new ArrayList<>();
        if (target == null) {
            errors.add("Target object to validate is null.");
            return errors;
        }

        Field[] fields = target.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(target);

                // Check @NotNull
                if (field.isAnnotationPresent(NotNull.class)) {
                    if (value == null) {
                        errors.add("[" + field.getName() + "]: " + field.getAnnotation(NotNull.class).message());
                        continue; // Skip further checks if null
                    }
                }

                // String-specific validations
                if (value instanceof String) {
                    String str = (String) value;

                    // Check @StringRange
                    if (field.isAnnotationPresent(StringRange.class)) {
                        StringRange range = field.getAnnotation(StringRange.class);
                        if (str.length() < range.min() || str.length() > range.max()) {
                            errors.add("[" + field.getName() + "]: " + range.message()
                                    + " (Current length: " + str.length() + ")");
                        }
                    }

                    // Check @EmailPattern
                    if (field.isAnnotationPresent(EmailPattern.class)) {
                        EmailPattern pattern = field.getAnnotation(EmailPattern.class);
                        if (!EMAIL_REGEX.matcher(str).matches()) {
                            errors.add("[" + field.getName() + "]: " + pattern.message() + " ('" + str + "')");
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                errors.add("[" + field.getName() + "]: Access error: " + e.getMessage());
            }
        }
        return errors;
    }
}

public class Q10_UserInputValidationFramework {
    public static void main(String[] args) {
        System.out.println("Testing Invalid User Input:");
        UserProfile invalidUser = new UserProfile("usr", "not-an-email", "123");
        List<String> errors1 = InputValidator.validate(invalidUser);
        for (String err : errors1) {
            System.out.println("  X " + err);
        }

        System.out.println("\nTesting Valid User Input:");
        UserProfile validUser = new UserProfile("vitthal_j", "vitthal@example.com", "SecurePass@2026");
        List<String> errors2 = InputValidator.validate(validUser);
        if (errors2.isEmpty()) {
            System.out.println("  V All input fields validated successfully without errors!");
        }
    }
}
