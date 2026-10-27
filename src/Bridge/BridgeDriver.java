package Bridge;

public class BridgeDriver {

    public static void main(String[] args) {
        //Part 1: online and cash payments with email and SMS
        PaymentNotification onlineEmail = new OnlinePaymentNotification(new EmailChanel());
        onlineEmail.notifyPayment();

        PaymentNotification onlineSms = new OnlinePaymentNotification(new SmsChanel());
        onlineSms.notifyPayment();

        PaymentNotification cashEmail = new CashOnDeliveryPayment(new EmailChanel());
        cashEmail.notifyPayment();

        PaymentNotification cashSms = new CashOnDeliveryPayment(new SmsChanel());
        cashSms.notifyPayment();

        //Part 2: Bitcoin with email and SMS
        PaymentNotification bitcoinEmail = new BitcoinPayment(new EmailChanel());
        bitcoinEmail.notifyPayment();

        PaymentNotification bitcoinSms = new BitcoinPayment(new SmsChanel());
        bitcoinSms.notifyPayment();

        //Part 3: two payment scenearios with push notifications
        PaymentNotification onlinePush = new OnlinePaymentNotification(new PushChanel());
        onlinePush.notifyPayment();

        PaymentNotification cashPush = new CashOnDeliveryPayment(new PushChanel());
        cashPush.notifyPayment();
    }
}
