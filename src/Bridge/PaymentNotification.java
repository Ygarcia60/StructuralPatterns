package Bridge;

public abstract class PaymentNotification implements NotificationChanel{
    protected final NotificationChanel chanel;

    protected PaymentNotification(NotificationChanel chanel) {
        this.chanel = chanel;
    }
    public abstract void notifyPayment();
}
