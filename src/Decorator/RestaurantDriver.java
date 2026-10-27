package Decorator;

public class RestaurantDriver {

    public static void main(String[] args) {
        //creating first foodie
        FoodItem burger = new Burger();
        burger = new Cheese(burger);
        burger = new Onions(burger);

        FoodItem fries = new Fries();
        fries = new Ketchup(fries);

        FoodItem hotdog = new HotDog();
        hotdog = new Ketchup(hotdog);
        hotdog = new Onions(hotdog);

        //Add created food items to Order
        Order order = new Order();
        order.addItem(burger);
        order.addItem(fries);
        order.addItem(hotdog);

        System.out.println("Customer Order: ");
        order.displayItems();

        double total = order.calculateTotal();
        System.out.printf("Total before discount: $%.2f%n", total);

        //Apply loyalty benefits
        LoyaltyStatus customerStatus = new LoyaltyStatus("Gold");
        double discountedTotal = customerStatus.applyDiscount(total);

        System.out.println("Loyalty Status: " + customerStatus.getStatus());
        System.out.printf("Total after discount: $%.2f%n", discountedTotal);
    }
}
