import java.util.Scanner;
import java.util.function.Function;

public class Q6_MethodReferenceSquare {

    static int square(int n) {
        return n * n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Function<Integer, Integer> squareFunc = Q6_MethodReferenceSquare::square;

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.println("Square of " + num + ": " + squareFunc.apply(num));

        sc.close();
    }
}
