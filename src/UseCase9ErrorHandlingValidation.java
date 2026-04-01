/*
 * ================================================================
 * MAIN CLASS – UseCase9ErrorHandlingValidation
 * ================================================================
 *
 * Use Case 9: Error Handling & Validation
 *
 * Description:
 * This class demonstrates how user input is validated before booking is processed.
 * The system:
 * - Accepts user input
 * - Validates input centrally
 * - Handles errors gracefully
 *
 * @version 9.0
 */
import java.util.Scanner;

public class UseCase9ErrorHandlingValidation {
    /**
     * Application entry point.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Display application header
        System.out.println("Booking Validation\n");
        Scanner scanner = new Scanner(System.in);
        try {
            // Initialize required components
            RoomInventory inventory = new RoomInventory();
            ReservationValidator validator = new ReservationValidator();
            // Input values
            System.out.print("Enter guest name: ");
            String guestName = scanner.nextLine();
            System.out.print("Enter room type (SingleRoom/DoubleRoom/SuiteRoom): ");
            String roomType = scanner.nextLine();
            // Attempt validation
            try {
                validator.validate(guestName, roomType, inventory);
                System.out.println("Booking valid!");
            } catch (InvalidBookingException e) {
                System.out.println("Booking failed: " + e.getMessage());
            }
        } finally {
            scanner.close();
        }
    }
}
