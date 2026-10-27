package Bridge;

public class CashOnDeliveryPayment extends PaymentNotification{
    public CashOnDeliveryPayment(NotificationChanel chanel) {
        super(chanel);
    }


    @Override
    public void send(String message) {}

    @Override
    public void notifyPayment() {
        chanel.send("Please pay with cash when your order is delivered");
    }
}
