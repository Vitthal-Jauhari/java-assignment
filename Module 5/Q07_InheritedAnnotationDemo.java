// Q07: Demonstrating annotation inheritance across class hierarchies using @Inherited.

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 1. Inherited Annotation: Subclasses automatically inherit this annotation
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Audited {
    String complianceLevel() default "ISO-27001";
}

// 2. Non-Inherited Annotation: Subclasses do NOT inherit this annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Transactional {}

@Audited(complianceLevel = "SOC-2")
@Transactional
class BaseAccountService {}

// Subclass does not explicitly define @Audited or @Transactional
class SavingsAccountService extends BaseAccountService {}

public class Q07_InheritedAnnotationDemo {
    public static void main(String[] args) {
        Class<?> subClass = SavingsAccountService.class;

        System.out.println("Checking annotations on subclass: " + subClass.getSimpleName());
        System.out.println("----------------------------------------------------------");

        // Check @Audited (annotated with @Inherited)
        boolean hasAudited = subClass.isAnnotationPresent(Audited.class);
        System.out.println("Is @Audited present on subclass?       " + hasAudited);
        if (hasAudited) {
            Audited audited = subClass.getAnnotation(Audited.class);
            System.out.println("  -> Inherited Compliance Level: " + audited.complianceLevel());
        }

        // Check @Transactional (NOT annotated with @Inherited)
        boolean hasTransactional = subClass.isAnnotationPresent(Transactional.class);
        System.out.println("Is @Transactional present on subclass? " + hasTransactional);
        System.out.println("Note: @Inherited only applies to class-level annotations inherited from superclasses (not interfaces).");
    }
}
