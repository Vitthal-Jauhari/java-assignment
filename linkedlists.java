import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedLists{
    public static void main(String[] args) {
        LinkedList<String> namesLinkedList = new LinkedList<>();
        ArrayList<String> namesArrayList = new ArrayList<>();

        namesLinkedList.add("Vitthal");
        namesLinkedList.add("Vinayak");
        namesLinkedList.add("Somya");
        namesLinkedList.add("Mahi");


        namesArrayList.add("Vitthal");
        namesArrayList.add("Vinayak");
        namesArrayList.add("Somya");
        namesArrayList.add("Mahi");

        namesLinkedList.add(1, "Aalia");
        namesArrayList.add(2, "Aalia");

        System.out.println(namesLinkedList);
        System.out.println(namesArrayList);
    }
}