import java.util.ArrayList;
import java.util.Scanner;

public class Q3_ArrayListDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.print("Enter number of elements: ");
        int count = sc.nextInt();

        System.out.println("Enter " + count + " integers:");
        for (int i = 0; i < count; i++) {
            numbers.add(sc.nextInt());
        }

        System.out.println("List: " + numbers);

        sc.close();
    }
}
