/*
 * ================================================================
 * MAIN CLASS – UseCase10BookingCancellation
 * ================================================================
 *
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * Description:
 * This class demonstrates how confirmed bookings can be cancelled safely.
 * Inventory is restored and rollback history is maintained.
 *
 * @version 10.0
 */
public class UseCase10BookingCancellation {
    /**
     * Application entry point.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        CancellationService cancelService = new CancellationService();
        // Simulate a confirmed booking
        String reservationId = "Single-1";
        String roomType = "SingleRoom";
        cancelService.registerBooking(reservationId, roomType);
        // Cancel the booking
        cancelService.cancelBooking(reservationId, inventory);
        // Show rollback history
        cancelService.showRollbackHistory();
        // Show updated inventory
        System.out.println("\nUpdated Single Room Availability: " + inventory.getRoomAvailability().get("SingleRoom"));
    }
}
