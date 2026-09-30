// Q04: Generic class Pair<K, V> holding two values of any type with getters and setters.

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Pair{" + "key=" + key + ", value=" + value + '}';
    }
}

public class Q04_GenericPair {
    public static void main(String[] args) {
        Pair<String, Integer> studentAge = new Pair<>("Alice", 21);
        System.out.println("Original Pair: " + studentAge);

        studentAge.setValue(22);
        System.out.println("Updated Pair : " + studentAge);

        Pair<Integer, String> httpStatus = new Pair<>(404, "Not Found");
        System.out.println("HTTP Status  : " + httpStatus.getKey() + " -> " + httpStatus.getValue());
    }
}
