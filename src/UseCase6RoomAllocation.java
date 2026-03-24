/**
 * ================================================================
 * MAIN CLASS – UseCase6RoomAllocation
 * ================================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Description:
 * This class demonstrates how booking requests are confirmed and rooms are allocated safely.
 * It consumes booking requests in FIFO order and updates inventory immediately.
 *
 * @version 6.0
 */
public class UseCase6RoomAllocation {
    /**
     * Application entry point.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Room Allocation Processing\n");
        // Setup inventory and queue
        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        RoomAllocationService allocationService = new RoomAllocationService();

        // Create booking requests
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Single");
        Reservation r3 = new Reservation("Vanmathi", "Suite");
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // Process requests in FIFO order
        while (bookingQueue.hasPendingRequests()) {
            Reservation next = bookingQueue.getNextRequest();
            allocationService.allocateRoom(next, inventory);
        }
    }
}
