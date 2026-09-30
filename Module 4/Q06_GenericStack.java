// Q06: User-defined generic class Stack<T> with push, pop, and peek operations.

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

class GenericStack<T> {
    private final List<T> elements = new ArrayList<>();

    public void push(T item) {
        elements.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.remove(elements.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.get(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }
}

public class Q06_GenericStack {
    public static void main(String[] args) {
        // Integer Stack
        System.out.println("--- Generic Integer Stack ---");
        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);

        System.out.println("Top element (peek): " + intStack.peek());
        System.out.println("Popped: " + intStack.pop());
        System.out.println("Top element after pop: " + intStack.peek());

        // String Stack
        System.out.println("\n--- Generic String Stack ---");
        GenericStack<String> strStack = new GenericStack<>();
        strStack.push("First");
        strStack.push("Second");
        strStack.push("Third");

        while (!strStack.isEmpty()) {
            System.out.println("Popped from String stack: " + strStack.pop());
        }
    }
}
