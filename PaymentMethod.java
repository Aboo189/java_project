abstract class PaymentMethod {
    protected double amount;
    public abstract void pay();
}

class CreditCardPayment extends PaymentMethod {
    private String cardNumber;
    public CreditCardPayment(double amount, String cardNumber) {
        this.amount = amount;
        this.cardNumber = cardNumber;
    }
    @Override
    public void pay() {
        // Credit card payment implementation
    }
}

class DebitCardPayment extends PaymentMethod {
    private String cardNumber;
    public DebitCardPayment(double amount, String cardNumber) {
        this.amount = amount;
        this.cardNumber = cardNumber;
    }
    @Override
    public void pay() {
        // Debit card payment implementation
    }
}
