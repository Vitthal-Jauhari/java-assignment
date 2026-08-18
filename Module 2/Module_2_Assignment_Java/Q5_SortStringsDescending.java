import java.util.ArrayList;
import java.util.Collections;

public class Q5_SortStringsDescending {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Banana");
        names.add("Apple");
        names.add("Mango");
        names.add("Cherry");

        names.sort((a, b) -> b.compareTo(a));

        System.out.println("Descending: " + names);
    }
}
