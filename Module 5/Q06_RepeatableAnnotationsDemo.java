// Q06: Demonstrating Repeatable Annotations introduced in Java 8 using @Repeatable.

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// 1. Container Annotation that holds an array of the repeatable annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Schedules {
    Schedule[] value();
}

// 2. Repeatable Annotation pointing to its container
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(Schedules.class)
@interface Schedule {
    String dayOfMonth() default "first";
    String dayOfWeek() default "Mon";
    int hour() default 12;
}

class MaintenanceTask {
    // Applying the same annotation multiple times to the same declaration
    @Schedule(dayOfMonth = "last", dayOfWeek = "Fri", hour = 23)
    @Schedule(dayOfMonth = "first", dayOfWeek = "Mon", hour = 2)
    @Schedule(dayOfMonth = "15th", dayOfWeek = "Wed", hour = 1)
    public void runDatabaseCleanup() {
        System.out.println("Running database cleanup...");
    }
}

public class Q06_RepeatableAnnotationsDemo {
    public static void main(String[] args) throws Exception {
        Method method = MaintenanceTask.class.getMethod("runDatabaseCleanup");

        // Reading repeatable annotations directly via getAnnotationsByType
        Schedule[] schedules = method.getAnnotationsByType(Schedule.class);

        System.out.println("Reading Repeatable @Schedule Annotations for " + method.getName() + "():");
        System.out.println("------------------------------------------------------------------");
        for (int i = 0; i < schedules.length; i++) {
            Schedule s = schedules[i];
            System.out.printf("Schedule #%d -> Day of Month: %-6s | Day of Week: %-4s | Hour: %02d:00%n",
                    (i + 1), s.dayOfMonth(), s.dayOfWeek(), s.hour());
        }
    }
}
