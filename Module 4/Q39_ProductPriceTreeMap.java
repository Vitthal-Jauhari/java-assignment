// Q39: Store a list of products and their prices in a TreeMap and display in sorted order by name.

import java.util.Map;
import java.util.TreeMap;

public class Q39_ProductPriceTreeMap {
    public static void main(String[] args) {
        // TreeMap naturally orders keys (product names) alphabetically
        Map<String, Double> productCatalog = new TreeMap<>();

        System.out.println("Inserting unsorted products...");
        productCatalog.put("Wireless Mouse", 29.99);
        productCatalog.put("Gaming Keyboard", 89.50);
        productCatalog.put("USB-C Hub", 34.00);
        productCatalog.put("4K Monitor", 349.99);
        productCatalog.put("Noise-Cancelling Headphones", 149.95);
        productCatalog.put("Bluetooth Speaker", 45.00);

        System.out.println("\nProducts & Prices (Automatically Sorted Alphabetically by Product Name):");
        System.out.println("=========================================================================");
        System.out.printf("%-35s | %10s%n", "Product Name", "Price (USD)");
        System.out.println("------------------------------------+-----------");
        for (Map.Entry<String, Double> entry : productCatalog.entrySet()) {
            System.out.printf("%-35s | $%9.2f%n", entry.getKey(), entry.getValue());
        }
        System.out.println("=========================================================================");
    }
}
