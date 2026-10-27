package Bridge;

public class SmsChanel implements NotificationChanel {
    @Override
    public void send(String message) {
        System.out.println("SMS : " + message);
    }
}
