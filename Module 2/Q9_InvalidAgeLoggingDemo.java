import java.util.Scanner;
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
        Scanner sc = new Scanner(System.in);
        FileHandler fileHandler = new FileHandler("age_errors.log", true);
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        try {
            checkAge(age);
        } catch (InvalidAgeException e) {
            logger.severe(e.getMessage());
            System.out.println("Exception logged: " + e.getMessage());
        }

        fileHandler.close();
        sc.close();
    }
}
