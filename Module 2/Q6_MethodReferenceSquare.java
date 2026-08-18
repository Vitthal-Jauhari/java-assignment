import java.util.function.Function;

public class Q6_MethodReferenceSquare {

    static int square(int n) {
        return n * n;
    }

    public static void main(String[] args) {
        Function<Integer, Integer> squareFunc = Q6_MethodReferenceSquare::square;
        System.out.println("Square of 7: " + squareFunc.apply(7));
    }
}
