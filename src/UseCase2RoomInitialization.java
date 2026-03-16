/**
 * ================================================================
 * MAIN CLASS – UseCase2RoomInitialization
 * ================================================================
 *
 * Use Case 2: Basic Room Types & Static Availability
 *
 * Description:
 * This class demonstrates room initialization using domain models before introducing centralized inventory management.
 * Availability is represented using simple variables to highlight limitations.
 *
 * @version 2.0
 */
public class UseCase2RoomInitialization {
    /**
     * Application entry point.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        int singleRoomAvailable = 5;
        int doubleRoomAvailable = 3;
        int suiteRoomAvailable = 2;

        Room single = new SingleRoom();
        Room doubleR = new DoubleRoom();
        Room suite = new SuiteRoom();

        System.out.println("\nRoom Types and Availability:");
        System.out.print("Single Room: ");
        single.displayRoomDetails();
        System.out.println("Available: " + singleRoomAvailable);

        System.out.print("Double Room: ");
        doubleR.displayRoomDetails();
        System.out.println("Available: " + doubleRoomAvailable);

        System.out.print("Suite Room: ");
        suite.displayRoomDetails();
        System.out.println("Available: " + suiteRoomAvailable);
    }
}
