/**
 * ================================================================
 * MAIN CLASS – UseCase3InventorySetup
 * ================================================================
 *
 * Use Case 3: Centralized Room Inventory Management
 *
 * Description:
 * This class demonstrates how room availability is managed using a centralized inventory.
 * Room objects are used to retrieve pricing and room characteristics.
 * No booking or search logic is introduced here.
 *
 * @version 3.0
 */
public class UseCase3InventorySetup {
    /**
     * Application entry point.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();

        // Display inventory status
        System.out.println("Hotel Room Inventory Status\n");
        for (String roomType : inventory.getRoomAvailability().keySet()) {
            int available = inventory.getRoomAvailability().get(roomType);
            Room room;
            switch (roomType) {
                case "SingleRoom":
                    room = new SingleRoom();
                    break;
                case "DoubleRoom":
                    room = new DoubleRoom();
                    break;
                case "SuiteRoom":
                    room = new SuiteRoom();
                    break;
                default:
                    continue;
            }
            System.out.println(roomType.replace("Room", " Room") + ":");
            System.out.println("Beds: " + room.numberOfBeds);
            System.out.println("Size: " + room.squareFeet + " sqft");
            System.out.println("Price per night: " + room.pricePerNight);
            System.out.println("Available Rooms: " + available + "\n");
        }
    }
}
