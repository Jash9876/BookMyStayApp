/**
 * ================================================================
 * CLASS – RoomAllocationService
 * ================================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Description:
 * This class is responsible for confirming booking requests and assigning rooms.
 * It ensures:
 * - Each room ID is unique
 * - Inventory is updated immediately
 * - No room is double-booked
 *
 * @version 6.0
 */
import java.util.*;

public class RoomAllocationService {
    /** Stores all allocated room IDs to prevent duplicate assignments. */
    private Set<String> allocatedRoomIds;
    /** Stores assigned room IDs by room type. */
    private Map<String, Set<String>> assignedRoomsByType;

    /** Initializes allocation tracking structures. */
    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    /**
     * Confirms a booking request by assigning a unique room ID and updating inventory.
     * @param reservation booking request
     * @param inventory centralized room inventory
     */
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String roomType = reservation.getRoomType();
        int available = inventory.getRoomAvailability().getOrDefault(roomType + "Room", 0);
        if (available > 0) {
            String roomId = generateRoomId(roomType);
            // Ensure uniqueness
            if (!allocatedRoomIds.contains(roomId)) {
                allocatedRoomIds.add(roomId);
                assignedRoomsByType.computeIfAbsent(roomType, k -> new HashSet<>()).add(roomId);
                // Decrement inventory
                inventory.updateAvailability(roomType + "Room", available - 1);
                System.out.println("Booking confirmed for Guest: " + reservation.getGuestName() + ", Room ID: " + roomId);
            } else {
                System.out.println("Error: Duplicate room ID allocation attempted for " + roomId);
            }
        } else {
            System.out.println("No available rooms for type: " + roomType);
        }
    }

    /**
     * Generates a unique room ID for the given room type.
     * @param roomType type of room
     * @return unique room ID
     */
    private String generateRoomId(String roomType) {
        int count = assignedRoomsByType.getOrDefault(roomType, new HashSet<>()).size() + 1;
        return roomType + "-" + count;
    }
}
