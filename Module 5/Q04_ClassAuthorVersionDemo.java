// Q04: Custom annotation to specify author and version of a class, read using Reflection.

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // Applicable to classes, interfaces, records, enums
@interface ClassInfo {
    String author();
    String version() default "1.0.0";
    String lastModified() default "2026-09-21";
    String[] reviewers() default {};
}

@ClassInfo(
    author = "Vitthal Jauhari",
    version = "2.3.0",
    lastModified = "2026-09-21",
    reviewers = {"Alice", "Bob"}
)
class OrderProcessingEngine {
    public void processOrder(int orderId) {
        System.out.println("Processing order: " + orderId);
    }
}

public class Q04_ClassAuthorVersionDemo {
    public static void main(String[] args) {
        Class<OrderProcessingEngine> clazz = OrderProcessingEngine.class;

        if (clazz.isAnnotationPresent(ClassInfo.class)) {
            ClassInfo info = clazz.getAnnotation(ClassInfo.class);
            System.out.println("Class Metadata retrieved via Reflection:");
            System.out.println("----------------------------------------");
            System.out.println("Target Class  : " + clazz.getSimpleName());
            System.out.println("Author        : " + info.author());
            System.out.println("Version       : " + info.version());
            System.out.println("Last Modified : " + info.lastModified());
            System.out.print("Reviewers     : ");
            for (String reviewer : info.reviewers()) {
                System.out.print(reviewer + " ");
            }
            System.out.println();
        } else {
            System.out.println("No @ClassInfo annotation found on " + clazz.getSimpleName());
        }
    }
}
