/**
 * ================================================================
 * CLASS – RoomSearchService
 * ================================================================
 *
 * Use Case 4: Room Search & Availability Check
 *
 * Description:
 * This class provides search functionality for guests to view available rooms.
 * It reads room availability from inventory and room details from Room objects.
 * No inventory mutation or booking logic is performed in this class.
 *
 * @version 4.0
 */
import java.util.Map;

public class RoomSearchService {
    /**
     * Displays available rooms along with their details and pricing.
     * This method performs read-only access to inventory and room data.
     *
     * @param inventory centralized room inventory
     * @param singleRoom single room definition
     * @param doubleRoom double room definition
     * @param suiteRoom suite room definition
     */
    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom) {
        Map<String, Integer> availability = inventory.getRoomAvailability();

        System.out.println("Room Search\n");

        // Check and display Single Room availability
        if (availability.getOrDefault("SingleRoom", 0) > 0) {
            System.out.println("Single Room:");
            System.out.println("Beds: " + singleRoom.numberOfBeds);
            System.out.println("Size: " + singleRoom.squareFeet + " sqft");
            System.out.println("Price per night: " + singleRoom.pricePerNight);
            System.out.println("Available: " + availability.get("SingleRoom") + "\n");
        }

        // Check and display Double Room availability
        if (availability.getOrDefault("DoubleRoom", 0) > 0) {
            System.out.println("Double Room:");
            System.out.println("Beds: " + doubleRoom.numberOfBeds);
            System.out.println("Size: " + doubleRoom.squareFeet + " sqft");
            System.out.println("Price per night: " + doubleRoom.pricePerNight);
            System.out.println("Available: " + availability.get("DoubleRoom") + "\n");
        }

        // Check and display Suite Room availability
        if (availability.getOrDefault("SuiteRoom", 0) > 0) {
            System.out.println("Suite Room:");
            System.out.println("Beds: " + suiteRoom.numberOfBeds);
            System.out.println("Size: " + suiteRoom.squareFeet + " sqft");
            System.out.println("Price per night: " + suiteRoom.pricePerNight);
            System.out.println("Available: " + availability.get("SuiteRoom") + "\n");
        }
    }
}
