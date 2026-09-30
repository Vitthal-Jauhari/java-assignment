// Q12: Sort an ArrayList of strings alphabetically and reverse alphabetically.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q12_SortArrayListStrings {
    public static void main(String[] args) {
        List<String> cities = new ArrayList<>();
        cities.add("Tokyo");
        cities.add("Berlin");
        cities.add("New York");
        cities.add("Amsterdam");
        cities.add("Paris");
        cities.add("London");

        System.out.println("Original list: " + cities);

        // Sort alphabetically (natural order)
        Collections.sort(cities);
        System.out.println("Alphabetical order: " + cities);

        // Sort reverse alphabetically
        Collections.sort(cities, Collections.reverseOrder());
        System.out.println("Reverse alphabetical order: " + cities);
    }
}
