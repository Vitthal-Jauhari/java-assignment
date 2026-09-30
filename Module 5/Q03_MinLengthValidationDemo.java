// Q03: Custom annotation @MinLength to validate minimum string length in a class using reflection.

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// Define custom @MinLength annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MinLength {
    int value(); // Minimum allowable length
    String message() default "String length is less than the required minimum.";
}

class UserRegistration {
    @MinLength(value = 5, message = "Username must be at least 5 characters.")
    private String username;

    @MinLength(value = 8, message = "Password must be at least 8 characters.")
    private String password;

    public UserRegistration(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

// Validator engine processing @MinLength annotations via Reflection
class AnnotationValidator {
    public static List<String> validate(Object obj) {
        List<String> errors = new ArrayList<>();
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(MinLength.class)) {
                field.setAccessible(true);
                MinLength annotation = field.getAnnotation(MinLength.class);
                try {
                    Object val = field.get(obj);
                    if (val instanceof String) {
                        String strVal = (String) val;
                        if (strVal == null || strVal.length() < annotation.value()) {
                            errors.add("Validation Error on field '" + field.getName() + "': "
                                    + annotation.message() + " (Actual length: "
                                    + (strVal == null ? 0 : strVal.length()) + ")");
                        }
                    }
                } catch (IllegalAccessException e) {
                    errors.add("Unable to access field: " + field.getName());
                }
            }
        }
        return errors;
    }
}

public class Q03_MinLengthValidationDemo {
    public static void main(String[] args) {
        UserRegistration invalidUser = new UserRegistration("bob", "secret");
        System.out.println("Validating invalidUser (username='bob', password='secret'):");
        List<String> errors1 = AnnotationValidator.validate(invalidUser);
        for (String err : errors1) {
            System.out.println("  " + err);
        }

        System.out.println("\nValidating validUser (username='charlie_b', password='StrongPassword123'):");
        UserRegistration validUser = new UserRegistration("charlie_b", "StrongPassword123");
        List<String> errors2 = AnnotationValidator.validate(validUser);
        if (errors2.isEmpty()) {
            System.out.println("  Validation Passed! All @MinLength constraints satisfied.");
        }
    }
}
