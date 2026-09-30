// Q01: Demonstrates built-in Java annotations: @Override, @Deprecated, and @SuppressWarnings.

class ParentService {
    public void executeTask() {
        System.out.println("ParentService executing task...");
    }

    @Deprecated(since = "2.0", forRemoval = true)
    public void oldLegacyMethod() {
        System.out.println("Warning: oldLegacyMethod is deprecated and will be removed.");
    }
}

class ChildService extends ParentService {
    // 1. @Override ensures the compiler verifies this method overrides a superclass method
    @Override
    public void executeTask() {
        System.out.println("ChildService executing enhanced task.");
    }

    // 2. @SuppressWarnings suppresses specific compiler warnings (e.g. deprecation, removal, unchecked)
    @SuppressWarnings({"deprecation", "removal"})
    public void callLegacy() {
        System.out.println("Calling deprecated method with warning suppressed:");
        oldLegacyMethod();
    }

    @SuppressWarnings("rawtypes")
    public void rawTypeUsage() {
        java.util.List list = new java.util.ArrayList();
        System.out.println("Suppressed rawtypes warning for legacy list: " + list);
    }
}

public class Q01_BuiltInAnnotationsDemo {
    public static void main(String[] args) {
        ChildService service = new ChildService();
        service.executeTask();
        service.callLegacy();
        service.rawTypeUsage();
    }
}
