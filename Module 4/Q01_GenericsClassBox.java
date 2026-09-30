// Q01: User-defined generic class Box<T> demonstrated with String and Integer.

class Box<T> {
    private T item;

    public void addItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

public class Q01_GenericsClassBox {
    public static void main(String[] args) {
        // Box holding String
        Box<String> stringBox = new Box<>();
        stringBox.addItem("Hello Generics!");
        System.out.println("String Box contains: " + stringBox.getItem());

        // Box holding Integer
        Box<Integer> intBox = new Box<>();
        intBox.addItem(100);
        System.out.println("Integer Box contains: " + intBox.getItem());
    }
}
