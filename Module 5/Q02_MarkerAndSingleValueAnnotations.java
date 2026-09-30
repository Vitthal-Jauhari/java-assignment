// Q02: Demonstrates Marker Annotations, Single-Value Annotations, and Default Values.

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// 1. Marker Annotation: Has no elements (acts as a tag/flag)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface AutoExecutable {}

// 2. Single-Value Annotation: Has a single element named 'value'
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Description {
    String value(); // Allows shorthand syntax @Description("...")
}

// 3. Annotation with Default Values
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Priority {
    int level() default 1; // Default value if omitted
    String category() default "General";
}

class TaskRunner {
    @AutoExecutable
    @Description("Initializes system resources")
    @Priority(level = 10, category = "Core")
    public void initSystem() {
        System.out.println("Running initSystem()...");
    }

    @Description("Backs up user data")
    @Priority // Uses defaults: level = 1, category = "General"
    public void backupData() {
        System.out.println("Running backupData()...");
    }

    @AutoExecutable
    @Description("Pings health check endpoint")
    public void healthCheck() {
        System.out.println("Running healthCheck()...");
    }
}

public class Q02_MarkerAndSingleValueAnnotations {
    public static void main(String[] args) throws Exception {
        TaskRunner runner = new TaskRunner();
        Method[] methods = TaskRunner.class.getDeclaredMethods();

        System.out.println("Processing annotations via Reflection:");
        System.out.println("-------------------------------------");
        for (Method method : methods) {
            System.out.println("Method: " + method.getName());

            if (method.isAnnotationPresent(AutoExecutable.class)) {
                System.out.println("  -> [Marker] Tagged with @AutoExecutable");
            }

            if (method.isAnnotationPresent(Description.class)) {
                Description desc = method.getAnnotation(Description.class);
                System.out.println("  -> [Single-Value] Description: \"" + desc.value() + "\"");
            }

            if (method.isAnnotationPresent(Priority.class)) {
                Priority p = method.getAnnotation(Priority.class);
                System.out.println("  -> [With Defaults] Priority Level: " + p.level() + ", Category: " + p.category());
            }

            // Automatically execute if tagged with marker
            if (method.isAnnotationPresent(AutoExecutable.class)) {
                System.out.print("  Executing: ");
                method.invoke(runner);
            }
            System.out.println();
        }
    }
}
