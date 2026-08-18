import java.util.ArrayList;
import java.util.Scanner;

public class Q5_SortStringsDescending {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();

        System.out.print("Enter the number of strings: ");
        int count = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.println("Enter " + count + " strings:");
        for (int i = 0; i < count; i++) {
            names.add(sc.nextLine());
        }

        names.sort((a, b) -> b.compareTo(a));

        System.out.println("Descending: " + names);

        sc.close();
    }
}
