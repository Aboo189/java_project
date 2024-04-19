public class TicketBookingImpl implements TicketBooking, TicketPayment {
    public boolean bookTicket(String eventName, String venue, String date, int quantity) {
        // code to book a ticket
        return true;
    }

    public boolean pay(int price, String paymentMethod) {
        // code to process payment
        return true;
    }
}