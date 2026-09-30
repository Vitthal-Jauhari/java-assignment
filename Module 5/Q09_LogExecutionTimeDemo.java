// Q09: Custom annotation @LogExecutionTime to measure and log method execution duration.

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
    String unit() default "MILLISECONDS";
}

// Service Interface
interface DataService {
    @LogExecutionTime
    void loadLargeDataset();

    @LogExecutionTime
    void sortData();

    void normalOperation(); // Not annotated
}

// Service Implementation
class DataServiceImpl implements DataService {
    @Override
    public void loadLargeDataset() {
        try {
            Thread.sleep(120); // Simulate I/O latency
        } catch (InterruptedException ignored) {}
        System.out.println("  [DataServiceImpl] Dataset loaded.");
    }

    @Override
    public void sortData() {
        try {
            Thread.sleep(80); // Simulate processing
        } catch (InterruptedException ignored) {}
        System.out.println("  [DataServiceImpl] Data sorted.");
    }

    @Override
    public void normalOperation() {
        System.out.println("  [DataServiceImpl] Normal operation performed.");
    }
}

// Dynamic Proxy Invocation Handler measuring execution time of annotated methods
class TimingInvocationHandler implements InvocationHandler {
    private final Object target;

    public TimingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Look up the implementation method to check for annotation
        Method targetMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());

        if (targetMethod.isAnnotationPresent(LogExecutionTime.class) || method.isAnnotationPresent(LogExecutionTime.class)) {
            long startTime = System.nanoTime();
            try {
                return method.invoke(target, args);
            } finally {
                long durationMs = (System.nanoTime() - startTime) / 1_000_000;
                System.out.printf("  -> [LOG] Method '%s' executed in %d ms%n", method.getName(), durationMs);
            }
        }
        return method.invoke(target, args);
    }
}

public class Q09_LogExecutionTimeDemo {
    public static void main(String[] args) {
        DataService originalService = new DataServiceImpl();

        // Create Dynamic Proxy wrapping the service
        DataService proxyService = (DataService) Proxy.newProxyInstance(
                DataService.class.getClassLoader(),
                new Class<?>[]{DataService.class},
                new TimingInvocationHandler(originalService)
        );

        System.out.println("Invoking methods via Dynamic Proxy with @LogExecutionTime:");
        System.out.println("----------------------------------------------------------");
        proxyService.loadLargeDataset();
        System.out.println();
        proxyService.sortData();
        System.out.println();
        proxyService.normalOperation();
    }
}
