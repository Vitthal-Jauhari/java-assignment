// Q02: Bounded type parameters in generics accepting only subclasses of Number.

class NumericCalculator<T extends Number> {
    private T num1;
    private T num2;

    public NumericCalculator(T num1, T num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double add() {
        return num1.doubleValue() + num2.doubleValue();
    }

    public double multiply() {
        return num1.doubleValue() * num2.doubleValue();
    }
}

public class Q02_BoundedTypeNumber {
    public static void main(String[] args) {
        NumericCalculator<Integer> intCalc = new NumericCalculator<>(15, 25);
        System.out.println("Integer Sum: " + intCalc.add());

        NumericCalculator<Double> doubleCalc = new NumericCalculator<>(12.5, 4.0);
        System.out.println("Double Multiplication: " + doubleCalc.multiply());

        // NumericCalculator<String> invalid = new NumericCalculator<>("a", "b"); // Compile Error: String is not a subclass of Number
    }
}
