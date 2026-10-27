package Bridge;

public class EmailChanel implements NotificationChanel {

    @Override
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}
