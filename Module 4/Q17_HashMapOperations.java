// Q17: HashMap of employee IDs and names performing:
// a. Add new key-value pairs
// b. Check if a key exists
// c. Iterate through the map using:
//    i.  KeySet
//    ii. EntrySet

import java.util.HashMap;
import java.util.Map;

public class Q17_HashMapOperations {
    public static void main(String[] args) {
        Map<Integer, String> employeeMap = new HashMap<>();

        // a. Add new key-value pairs
        employeeMap.put(101, "Alice Smith");
        employeeMap.put(102, "Bob Jones");
        employeeMap.put(103, "Charlie Brown");
        employeeMap.put(104, "Diana Prince");
        System.out.println("Employee Map initialized with " + employeeMap.size() + " entries.");

        // b. Check if a key exists
        int testId1 = 102;
        int testId2 = 999;
        System.out.println("Contains employee ID " + testId1 + "? " + employeeMap.containsKey(testId1));
        System.out.println("Contains employee ID " + testId2 + "? " + employeeMap.containsKey(testId2));

        // c. i. Iteration using KeySet
        System.out.println("\n--- c.i Iterating using KeySet ---");
        for (Integer empId : employeeMap.keySet()) {
            System.out.println("Key: " + empId + ", Value: " + employeeMap.get(empId));
        }

        // c. ii. Iteration using EntrySet
        System.out.println("\n--- c.ii Iterating using EntrySet ---");
        for (Map.Entry<Integer, String> entry : employeeMap.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " -> Employee: " + entry.getValue());
        }
    }
}
