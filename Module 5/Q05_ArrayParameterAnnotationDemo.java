// Q05: Demonstrating that annotations can accept arrays as parameters.

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RolesAllowed {
    String[] value(); // Array of strings representing permitted user roles
    int[] allowedSecurityLevels() default {1, 2};
}

class AdminService {
    @RolesAllowed(value = {"ADMIN", "SUPERUSER"}, allowedSecurityLevels = {4, 5})
    public void deleteDatabase() {
        System.out.println("Executing sensitive database deletion...");
    }

    @RolesAllowed({"USER", "ADMIN"}) // Single or array initializer shorthand
    public void viewDashboard() {
        System.out.println("Displaying dashboard...");
    }
}

public class Q05_ArrayParameterAnnotationDemo {
    public static void main(String[] args) throws Exception {
        Method[] methods = AdminService.class.getDeclaredMethods();

        System.out.println("Inspecting Array Parameters in Annotations:");
        System.out.println("--------------------------------------------");
        for (Method method : methods) {
            if (method.isAnnotationPresent(RolesAllowed.class)) {
                RolesAllowed roles = method.getAnnotation(RolesAllowed.class);
                System.out.println("Method: " + method.getName());
                System.out.println("  Allowed Roles          : " + Arrays.toString(roles.value()));
                System.out.println("  Allowed Security Levels: " + Arrays.toString(roles.allowedSecurityLevels()));
                System.out.println();
            }
        }
    }
}
