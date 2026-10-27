package Bridge;

public class PushChanel implements NotificationChanel{
    @Override
    public void send(String message) {
        System.out.println("Push: " + message);
    }
}
