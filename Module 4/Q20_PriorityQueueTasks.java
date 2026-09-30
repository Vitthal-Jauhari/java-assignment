// Q20: Using PriorityQueue to store tasks with priorities, removing highest-priority task first.

import java.util.PriorityQueue;

class Task implements Comparable<Task> {
    private final String description;
    private final int priority; // Lower number = higher urgency (1 is highest)

    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Task other) {
        // Natural ordering based on priority number ascending (1 before 5)
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "Task('" + description + "', Priority=" + priority + ")";
    }
}

public class Q20_PriorityQueueTasks {
    public static void main(String[] args) {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();

        // Add tasks with varying priorities
        taskQueue.offer(new Task("Respond to urgent client email", 2));
        taskQueue.offer(new Task("Fix critical production bug", 1));
        taskQueue.offer(new Task("Submit weekly report", 4));
        taskQueue.offer(new Task("Conduct code review", 3));
        taskQueue.offer(new Task("Organize desk workspace", 5));

        System.out.println("Processing tasks in priority order (1 is highest priority):");
        System.out.println("----------------------------------------------------------");
        while (!taskQueue.isEmpty()) {
            Task currentTask = taskQueue.poll();
            System.out.println("Executing -> " + currentTask);
        }
    }
}
