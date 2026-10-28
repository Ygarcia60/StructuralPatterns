package Test;

import Bridge.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BridgeTest {

    @Test
    public void emailChannelSendsMessage() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        try {
            System.setOut(new PrintStream(output));

            NotificationChanel channel = new EmailChanel();
            channel.send("Test message");

            assertTrue(output.toString().contains("Email: Test message"));
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void smsChannelSendsMessage() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        try {
            System.setOut(new PrintStream(output));

            NotificationChanel channel = new SmsChanel();
            channel.send("Test message");

            assertTrue(output.toString().contains("SMS : Test message"));
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void pushChannelSendsMessage() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        try {
            System.setOut(new PrintStream(output));

            NotificationChanel channel = new PushChanel();
            channel.send("Test message");

            assertTrue(output.toString().contains("Push: Test message"));
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void onlinePaymentSendsItsMessage() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        try {
            System.setOut(new PrintStream(output));

            PaymentNotification payment =
                    new OnlinePaymentNotification(new SmsChanel());

            payment.notifyPayment();

            assertTrue(output.toString().contains(
                    "Your online payment was successful"
            ));
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void cashPaymentSendsItsMessage() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        try {
            System.setOut(new PrintStream(output));

            PaymentNotification payment =
                    new CashOnDeliveryPayment(new SmsChanel());

            payment.notifyPayment();

            assertTrue(output.toString().contains(
                    "Please pay with cash when your order is delivered"
            ));
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void bitcoinPaymentSendsItsMessage() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        try {
            System.setOut(new PrintStream(output));

            PaymentNotification payment =
                    new BitcoinPayment(new SmsChanel());

            payment.notifyPayment();

            assertTrue(output.toString().contains(
                    "Your Bitcoin payment was successful"
            ));
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void paymentDriverRuns() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        try {
            System.setOut(new PrintStream(output));

            BridgeDriver.main(new String[0]);

            assertTrue(output.toString().contains("Push:"));
        } finally {
            System.setOut(originalOut);
        }
    }
}
