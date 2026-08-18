import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Q9_InvalidAgeLoggingDemo {

    static Logger logger = Logger.getLogger(Q9_InvalidAgeLoggingDemo.class.getName());

    static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above. Given: " + age);
        }
        System.out.println("Age accepted: " + age);
    }

    public static void main(String[] args) throws Exception {
        FileHandler fileHandler = new FileHandler("age_errors.log", true);
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);

        try {
            checkAge(15);
        } catch (InvalidAgeException e) {
            logger.severe(e.getMessage());
            System.out.println("Exception logged: " + e.getMessage());
        }
    }
}
