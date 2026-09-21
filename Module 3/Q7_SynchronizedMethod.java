// Q7: Synchronized Method - Ticket booking system preventing overselling of tickets.

class TicketCounter {
    private int availableTickets;

    public TicketCounter(int availableTickets) {
        this.availableTickets = availableTickets;
    }

    // Synchronized method ensures thread-safe ticket booking
    public synchronized void bookTicket(String passengerName, int numberOfTickets) {
        if (availableTickets >= numberOfTickets) {
            System.out.println(passengerName + " successfully booked " + numberOfTickets + " ticket(s).");
            availableTickets -= numberOfTickets;
            System.out.println("Remaining tickets: " + availableTickets);
        } else {
            System.out.println(passengerName + " failed to book " + numberOfTickets + " ticket(s). Only "
                    + availableTickets + " remaining.");
        }
    }
}

class Passenger extends Thread {
    private TicketCounter counter;
    private String name;
    private int requestedTickets;

    public Passenger(TicketCounter counter, String name, int requestedTickets) {
        this.counter = counter;
        this.name = name;
        this.requestedTickets = requestedTickets;
    }

    @Override
    public void run() {
        counter.bookTicket(name, requestedTickets);
    }
}

public class Q7_SynchronizedMethod {
    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter(5);

        Passenger p1 = new Passenger(counter, "Alice", 2);
        Passenger p2 = new Passenger(counter, "Bob", 3);
        Passenger p3 = new Passenger(counter, "Charlie", 2);

        p1.start();
        p2.start();
        p3.start();
    }
}
