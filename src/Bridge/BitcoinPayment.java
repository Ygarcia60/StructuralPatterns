package Bridge;

public class BitcoinPayment extends PaymentNotification{
    public BitcoinPayment(NotificationChanel chanel) {
        super(chanel);
    }

    @Override
    public void send(String message) {}

    @Override
    public void notifyPayment() {
        chanel.send("Your Bitcoin payment was successful");
    }
}
