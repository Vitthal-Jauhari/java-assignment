// Q31: Basic To-Do list application using ArrayList storing tasks with add, remove, and display operations.

import java.util.ArrayList;
import java.util.List;

class TodoList {
    private final List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Added: \"" + task + "\"");
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            String removed = tasks.remove(index);
            System.out.println("Removed task " + (index + 1) + ": \"" + removed + "\"");
        } else {
            System.out.println("Error: Invalid task index " + index);
        }
    }

    public void displayTasks() {
        System.out.println("\n--- Current To-Do List (" + tasks.size() + " tasks) ---");
        if (tasks.isEmpty()) {
            System.out.println("No tasks pending!");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.println("----------------------------------------\n");
    }
}

public class Q31_TodoListApp {
    public static void main(String[] args) {
        TodoList todo = new TodoList();

        todo.addTask("Complete Java Module 4 Assignment");
        todo.addTask("Prepare presentation slides");
        todo.addTask("Review Pull Requests on GitHub");
        todo.addTask("Submit assignment report");

        todo.displayTasks();

        // Remove task at index 1 ("Prepare presentation slides")
        todo.removeTask(1);

        todo.displayTasks();
    }
}
