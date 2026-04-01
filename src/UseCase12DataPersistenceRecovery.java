/*
 * ================================================================
 * MAIN CLASS – UseCase12DataPersistenceRecovery
 * ================================================================
 *
 * Use Case 12: Data Persistence & System Recovery
 *
 * Description:
 * This class demonstrates how system state can be restored after an application restart.
 * Inventory data is loaded from a file and any booking modifications can be saved.
 *
 * @version 12.0
 */
public class UseCase12DataPersistenceRecovery {
    /**
     * Application entry point.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        String filePath = "inventory.txt";
        RoomInventory inventory = new RoomInventory();
        FilePersistenceService persistence = new FilePersistenceService();
        System.out.println("System Recovery");
        persistence.loadInventory(inventory, filePath);
        // Display current inventory
        System.out.println("\nCurrent Inventory:");
        System.out.println("Single: " + inventory.getRoomAvailability().getOrDefault("SingleRoom", 0));
        System.out.println("Double: " + inventory.getRoomAvailability().getOrDefault("DoubleRoom", 0));
        System.out.println("Suite: " + inventory.getRoomAvailability().getOrDefault("SuiteRoom", 0));
        // Save inventory state
        persistence.saveInventory(inventory, filePath);
    }
}
