package Decorator;

public class LoyaltyStatus {
    private final String status;

    public LoyaltyStatus(String status) {
        this.status = status;
    }

    public double applyDiscount(double total) {
        double discountRate;

        if (status.equalsIgnoreCase("Gold")) {
            discountRate = 0.15;
        } else if (status.equalsIgnoreCase("Silver")) {
            discountRate = 0.10;
        } else {
            discountRate = 0.0;
        }
        return total * (1-discountRate);
    }
    public String getStatus() {
        return  status;
    }
}
