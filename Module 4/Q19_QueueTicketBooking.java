// Q19: Simple program using Queue (with LinkedList) to simulate a ticket booking queue.

import java.util.LinkedList;
import java.util.Queue;

public class Q19_QueueTicketBooking {
    public static void main(String[] args) {
        // Queue follows FIFO (First-In, First-Out)
        Queue<String> ticketQueue = new LinkedList<>();

        // Customers join the line
        ticketQueue.offer("Passenger Alice");
        ticketQueue.offer("Passenger Bob");
        ticketQueue.offer("Passenger Charlie");
        ticketQueue.offer("Passenger Diana");

        System.out.println("Initial ticket queue: " + ticketQueue);

        // Serving customers in order of arrival
        while (!ticketQueue.isEmpty()) {
            // peek() looks at the front customer without removing
            System.out.println("Next to be served: " + ticketQueue.peek());

            // poll() serves and removes the customer from the queue
            String servedCustomer = ticketQueue.poll();
            System.out.println("Issued ticket to: " + servedCustomer);
            System.out.println("Queue size now: " + ticketQueue.size() + "\n");
        }

        System.out.println("All passengers have been served. Queue is empty.");
    }
}
