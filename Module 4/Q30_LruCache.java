// Q30: LRU (Least Recently Used) Cache using LinkedHashMap.

import java.util.LinkedHashMap;
import java.util.Map;

class LruCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    // accessOrder = true enables LRU tracking on get() and put()
    public LruCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    // Called automatically after put() to evict the eldest entry when capacity is exceeded
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}

public class Q30_LruCache {
    public static void main(String[] args) {
        System.out.println("Creating LRU Cache of capacity 3...");
        LruCache<Integer, String> cache = new LruCache<>(3);

        cache.put(1, "Page-1");
        cache.put(2, "Page-2");
        cache.put(3, "Page-3");
        System.out.println("Cache after inserting 1, 2, 3: " + cache);

        // Access page 1 -> makes 1 the most recently used; 2 becomes eldest
        System.out.println("Accessing key 1: " + cache.get(1));
        System.out.println("Cache order after accessing 1: " + cache);

        // Insert page 4 -> triggers eviction of key 2 (least recently used)
        System.out.println("Inserting key 4 (Page-4)...");
        cache.put(4, "Page-4");
        System.out.println("Cache state after eviction: " + cache);
        System.out.println("Is key 2 present? " + cache.containsKey(2));
    }
}
