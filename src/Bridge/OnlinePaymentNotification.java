package Bridge;

public class OnlinePaymentNotification extends PaymentNotification {
    public OnlinePaymentNotification(NotificationChanel chanel) {
        super(chanel);
    }

    @Override
    public void notifyPayment() {
        chanel.send("Your online payment was successful");
    }

    @Override
    public void send(String message) {}
}
