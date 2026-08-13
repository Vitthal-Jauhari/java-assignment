// WAP that uses Java's StringBuilder for efficient string operations

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");

        sb.append(" World");
        System.out.println("After append: " + sb);

        sb.insert(5, ",");
        System.out.println("After insert: " + sb);

        sb.reverse();
        System.out.println("After reverse: " + sb);

        sb.reverse();
        sb.delete(5, 6);
        System.out.println("After delete: " + sb);

        sb.replace(0, 5, "Hi");
        System.out.println("After replace: " + sb);
    }
}
