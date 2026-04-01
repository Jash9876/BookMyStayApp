/*
 * ================================================================
 * MAIN CLASS – UseCase8BookingHistoryReport
 * ================================================================
 *
 * Use Case 8: Booking History & Reporting
 *
 * Description:
 * This class demonstrates how confirmed bookings are stored and reported.
 * The system maintains an ordered audit trail of reservations.
 *
 * @version 8.0
 */
public class UseCase8BookingHistoryReport {
    /**
     * Application entry point.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Create booking history
        BookingHistory history = new BookingHistory();
        // Add confirmed reservations
        history.addConfirmedReservation(new Reservation("Abhi", "Single"));
        history.addConfirmedReservation(new Reservation("Subha", "Double"));
        history.addConfirmedReservation(new Reservation("Vanmathi", "Suite"));
        // Generate and display report
        BookingReportService reportService = new BookingReportService();
        reportService.generateReport(history);
    }
}
