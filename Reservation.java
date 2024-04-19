import java.time.LocalDate;

public class Reservation {
    private Ticket ticket;
    private PaymentMethod paymentMethod;
    private String reservationDate;
    private boolean isConfirmed;

    public Reservation(Ticket ticket) {
        this.ticket = ticket;
        this.paymentMethod = paymentMethod;
        this.reservationDate = LocalDate.now().toString();
        this.isConfirmed = false;
    }

    public void confirm() {
        paymentMethod.pay();
        isConfirmed = true;
    }

    public Ticket getTicket() {
        return ticket;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public String getReservationDate() {
        return reservationDate;
    }
    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void bookTicket() {

    }
}