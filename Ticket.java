public class Ticket {
    private String ticketNumber;
    private String passengerName;
    private String bookingDate;
    private double ticketPrice;

    public Ticket(String ticketNumber, String passengerName, String bookingDate, double ticketPrice) {
        this.ticketNumber = ticketNumber;
        this.passengerName = passengerName;
        this.bookingDate = bookingDate;
        this.ticketPrice = ticketPrice;
    }

    public Ticket() {
    }

    public String getTicketNumber() {
        return ticketNumber;
    }
    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
    public String getPassengerName() {
        return passengerName;
    }
    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }
    public String getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }
    public double getTicketPrice() {
        return ticketPrice;
    }
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}