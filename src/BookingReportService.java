/*
 * ================================================================
 * CLASS – BookingReportService
 * ================================================================
 *
 * Use Case 8: Booking History & Reporting
 *
 * Description:
 * Main class generates reports from Booking History.
 * Reporting logic is separated from data storage.
 *
 * @version 8.0
 */
public class BookingReportService {
    /**
     * Displays a summary report of all confirmed bookings.
     * @param history booking history
     */
    public void generateReport(BookingHistory history) {
        System.out.println("\nBooking History and Reporting\n");
        for (Reservation r : history.getConfirmedReservations()) {
            System.out.println("Guest: " + r.getGuestName() + ", Room Type: " + r.getRoomType());
        }
    }
}
