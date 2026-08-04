// Implement a singleton class in Java

class Logger {
    private static Logger instance;

    // private constructor prevents outside instantiation
    private Logger() {
        System.out.println("Logger instance created");
    }

    static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    void log(String message) {
        System.out.println("LOG: " + message);
    }
}

public class singleton {
    public static void main(String[] args) {
        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();

        l1.log("First message");
        l2.log("Second message");

        System.out.println("l1 == l2: " + (l1 == l2));
    }
}
