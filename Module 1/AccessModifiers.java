// Explain and implement the concept of access modifiers in Java

class Account {
    public String bankName = "SBI";
    protected double balance = 1000.0;
    private String pin = "1234";
    String branch = "Noida"; // default access

    void showPin() {
        System.out.println("Pin (accessed within class): " + pin);
    }
}

public class AccessModifiers {
    public static void main(String[] args) {
        Account acc = new Account();

        System.out.println("Public: " + acc.bankName);
        System.out.println("Protected: " + acc.balance);
        System.out.println("Default: " + acc.branch);
        acc.showPin();
    }
}
