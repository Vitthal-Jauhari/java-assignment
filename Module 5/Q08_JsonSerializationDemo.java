// Q08: Custom annotation @JsonField to specify custom field names for JSON serialization.

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String value() default ""; // Custom JSON property name
    boolean ignore() default false; // Flag to exclude field from JSON output
}

class ProductDto {
    @JsonField("product_id")
    private int id;

    @JsonField("product_name")
    private String name;

    @JsonField("unit_price")
    private double price;

    @JsonField(ignore = true)
    private String internalSupplierCode;

    public ProductDto(int id, String name, double price, String internalSupplierCode) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.internalSupplierCode = internalSupplierCode;
    }
}

class SimpleJsonSerializer {
    public static String toJson(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        Map<String, String> jsonElements = new LinkedHashMap<>();

        for (Field field : fields) {
            field.setAccessible(true);
            String jsonKey = field.getName();
            boolean ignore = false;

            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                if (annotation.ignore()) {
                    continue; // Skip ignored fields
                }
                if (!annotation.value().isEmpty()) {
                    jsonKey = annotation.value();
                }
            }

            Object value = field.get(obj);
            String formattedValue;
            if (value instanceof String) {
                formattedValue = "\"" + value + "\"";
            } else {
                formattedValue = String.valueOf(value);
            }
            jsonElements.put(jsonKey, formattedValue);
        }

        StringBuilder sb = new StringBuilder("{\n");
        int count = 0;
        for (Map.Entry<String, String> entry : jsonElements.entrySet()) {
            sb.append("  \"").append(entry.getKey()).append("\": ").append(entry.getValue());
            if (++count < jsonElements.size()) {
                sb.append(",");
            }
            sb.append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}

public class Q08_JsonSerializationDemo {
    public static void main(String[] args) throws Exception {
        ProductDto product = new ProductDto(1001, "Ultra HD Monitor", 349.99, "SUP-SECRET-998");

        System.out.println("Serializing ProductDto object using @JsonField:");
        System.out.println("----------------------------------------------");
        String json = SimpleJsonSerializer.toJson(product);
        System.out.println(json);
    }
}
