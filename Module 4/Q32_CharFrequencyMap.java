// Q32: Count the frequency of characters in a string using a HashMap.

import java.util.HashMap;
import java.util.Map;

public class Q32_CharFrequencyMap {

    public static Map<Character, Integer> countFrequencies(String text) {
        Map<Character, Integer> freqMap = new HashMap<>();
        if (text == null) return freqMap;

        for (char ch : text.toCharArray()) {
            // merge() atomically initializes to 1 or increments existing count
            freqMap.merge(ch, 1, Integer::sum);
        }
        return freqMap;
    }

    public static void main(String[] args) {
        String input = "Java Multithreading and Collections Framework";
        System.out.println("Input String: \"" + input + "\"");

        Map<Character, Integer> frequencies = countFrequencies(input);

        System.out.println("\nCharacter Frequencies:");
        System.out.println("----------------------");
        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            char ch = entry.getKey();
            String displayChar = (ch == ' ') ? "' ' (Space)" : "'" + ch + "'";
            System.out.printf("%-15s : %d%n", displayChar, entry.getValue());
        }
    }
}
