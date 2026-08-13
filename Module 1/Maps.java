import java.util.HashMap;

public class Maps{
    public static void main(String[] args) {
        HashMap<String, Integer> empIDs = new HashMap();

        empIDs.put("Vitthal", 12345);
        empIDs.put("Vinayak", 67890);
        empIDs.put("Mahi", 304103);

        System.err.println(empIDs.get("Vitthal"));

        System.out.println(empIDs);

        System.out.println(empIDs["Vitthal"]);

        empIDs.remove("Vitthal");

        System.out.println(empIDs);

    }
}