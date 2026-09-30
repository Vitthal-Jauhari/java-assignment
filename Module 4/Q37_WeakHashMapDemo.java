// Q37: Using WeakHashMap to demonstrate how entries are garbage-collected when keys are no longer strongly referenced.

import java.util.Map;
import java.util.WeakHashMap;

class MetadataKey {
    private final String name;

    public MetadataKey(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MetadataKey(" + name + ")";
    }
}

public class Q37_WeakHashMapDemo {
    public static void main(String[] args) throws InterruptedException {
        Map<MetadataKey, String> weakMap = new WeakHashMap<>();

        // Create strong references to keys
        MetadataKey key1 = new MetadataKey("Resource-1");
        MetadataKey key2 = new MetadataKey("Resource-2");

        weakMap.put(key1, "Cached-Data-1");
        weakMap.put(key2, "Cached-Data-2");

        System.out.println("WeakHashMap with strong references: " + weakMap);
        System.out.println("Map size: " + weakMap.size());

        // Clear strong reference to key1
        System.out.println("\nNullifying strong reference to key1...");
        key1 = null;

        // Request Garbage Collection
        System.out.println("Invoking System.gc()...");
        System.gc();

        // Small pause to allow GC finalization
        Thread.sleep(100);

        System.out.println("\nWeakHashMap after System.gc(): " + weakMap);
        System.out.println("Map size: " + weakMap.size());
        System.out.println("Notice: Entry for key1 was automatically collected because its key had only a weak reference!");
    }
}
