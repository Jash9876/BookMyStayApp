/*
 * ================================================================
 * MAIN CLASS – UseCase11ConcurrentBookingSimulation
 * ================================================================
 *
 * Use Case 11: Concurrent Booking Simulation
 *
 * Description:
 * This class simulates multiple users attempting to book rooms at the same time.
 * It highlights race conditions and demonstrates how synchronization prevents inconsistent allocation.
 *
 * @version 11.0
 */
public class UseCase11ConcurrentBookingSimulation {
    /**
     * Application entry point.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Shared resources
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocationService = new RoomAllocationService();
        // Add booking requests
        bookingQueue.addRequest(new Reservation("Abhi", "SingleRoom"));
        bookingQueue.addRequest(new Reservation("Subha", "DoubleRoom"));
        bookingQueue.addRequest(new Reservation("Vanmathi", "SuiteRoom"));
        bookingQueue.addRequest(new Reservation("Ravi", "SingleRoom"));
        bookingQueue.addRequest(new Reservation("Priya", "DoubleRoom"));
        // Create booking processor tasks
        Thread t1 = new Thread(new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService));
        Thread t2 = new Thread(new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService));
        // Start concurrent processing
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread execution interrupted.");
        }
    }
}
