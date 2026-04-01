/*
 * ================================================================
 * CLASS – CancellationService
 * ================================================================
 *
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * Description:
 * This class is responsible for handling booking cancellations.
 * It ensures that:
 * - Cancelled room IDs are tracked
 * - Inventory is restored correctly
 * - Invalid cancellations are prevented
 * A stack is used to model rollback behavior.
 *
 * @version 10.0
 */
import java.util.*;

public class CancellationService {
    /** Stack that stores recently released room IDs. */
    private Stack<String> releasedRoomIds;
    /** Maps reservation ID to room type. */
    private Map<String, String> reservationIdToRoomType;

    /** Initializes cancellation tracking structures. */
    public CancellationService() {
        releasedRoomIds = new Stack<>();
        reservationIdToRoomType = new HashMap<>();
    }

    /**
     * Registers a confirmed booking.
     * This method exists during confirmation and adds data that will later be required for cancellation.
     * @param reservationId confirmed reservation ID
     * @param roomType confirmed room type
     */
    public void registerBooking(String reservationId, String roomType) {
        reservationIdToRoomType.put(reservationId, roomType);
    }

    /**
     * Cancels a confirmed booking.
     * @param reservationId reservation to cancel
     * @param inventory centralized room inventory
     */
    public void cancelBooking(String reservationId, RoomInventory inventory) {
        if (!reservationIdToRoomType.containsKey(reservationId)) {
            System.out.println("Cancellation failed: Reservation does not exist or already cancelled.");
            return;
        }
        String roomType = reservationIdToRoomType.get(reservationId);
        // Release room ID (simulate rollback)
        releasedRoomIds.push(reservationId);
        // Restore inventory
        inventory.getRoomAvailability().put(roomType, inventory.getRoomAvailability().get(roomType) + 1);
        // Remove from active bookings
        reservationIdToRoomType.remove(reservationId);
        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
    }

    /**
     * Shows recently cancelled reservations.
     * This method helps visualize rollback order.
     */
    public void showRollbackHistory() {
        System.out.println("\nRollback History (Most Recent First):");
        for (String id : releasedRoomIds) {
            System.out.println("Released Reservation ID: " + id);
        }
    }
}
