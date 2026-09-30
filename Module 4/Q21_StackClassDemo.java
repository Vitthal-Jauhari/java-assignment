// Q21: Implementing a Stack using the java.util.Stack class with push, pop, peek, and isEmpty.

import java.util.Stack;

public class Q21_StackClassDemo {
    public static void main(String[] args) {
        Stack<String> bookStack = new Stack<>();

        System.out.println("Is stack initially empty? " + bookStack.isEmpty());

        // push() operations (LIFO)
        bookStack.push("Book A: Data Structures");
        bookStack.push("Book B: Operating Systems");
        bookStack.push("Book C: Computer Networks");
        bookStack.push("Book D: Design Patterns");

        System.out.println("Stack after pushes: " + bookStack);
        System.out.println("Is stack empty now? " + bookStack.isEmpty());
        System.out.println("Stack size: " + bookStack.size());

        // peek() operation (views top element without removal)
        System.out.println("Top element (peek): " + bookStack.peek());

        // pop() operation (removes and returns top element)
        System.out.println("Popped element: " + bookStack.pop());
        System.out.println("New top element: " + bookStack.peek());

        // popping remaining elements
        System.out.println("\nPopping all elements from stack:");
        while (!bookStack.isEmpty()) {
            System.out.println("Removed: " + bookStack.pop());
        }

        System.out.println("Is stack empty at the end? " + bookStack.isEmpty());
    }
}
