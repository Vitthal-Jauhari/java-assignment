// Write a program to identify valid and invalid identifiers in Java

public class identifiers {
    static boolean isValidIdentifier(String id) {
        if (id.isEmpty()) {
            return false;
        }
        if (!Character.isLetter(id.charAt(0)) && id.charAt(0) != '_' && id.charAt(0) != '$') {
            return false;
        }
        for (int i = 1; i < id.length(); i++) {
            char c = id.charAt(i);
            if (!Character.isLetterOrDigit(c) && c != '_' && c != '$') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] testIds = {"num1", "1num", "_value", "my-var", "$total", "class"};

        for (String id : testIds) {
            if (isValidIdentifier(id)) {
                System.out.println(id + " is a valid identifier");
            } else {
                System.out.println(id + " is an invalid identifier");
            }
        }
    }
}
