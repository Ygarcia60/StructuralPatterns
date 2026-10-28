package Test;

import Decorator.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DecoratorTest {
    private static final double DELTA = 0.001;

    @Test
    public void burgerHasDescriptionAndCost() {
        FoodItem burger = new Burger();

        assertEquals("Burger", burger.getDescription());
        assertEquals(5.00, burger.getCost(), DELTA);
    }
    @Test
    public void friesHaveDescriptionAndCost() {
        FoodItem fries = new Fries();

        assertEquals("Fries", fries.getDescription());
        assertEquals(2.50, fries.getCost(), DELTA);
    }
    @Test
    public void hotDogHasDescriptionAndCost() {
        FoodItem hotdog = new HotDog();

        assertEquals("HotDog", hotdog.getDescription());
        assertEquals(3.50, hotdog.getCost(), DELTA);
    }

    @Test
    public void cheeseAddsDescriptionAndCost() {
        FoodItem item = new Cheese(new Burger());

        assertEquals("Burger, cheese", item.getDescription());
        assertEquals(5.75, item.getCost(), DELTA);
    }
    @Test
    public void ketchupAddsDescriptionAndCost() {
        FoodItem item = new Ketchup(new Fries());

        assertEquals("Fries, ketchup", item.getDescription());
        assertEquals(2.75, item.getCost(), DELTA);
    }
    @Test
    public void onionsAddsDescriptionAndCost() {
        FoodItem item = new Onions(new Burger());

        assertEquals("Burger, onions", item.getDescription());
        assertEquals(5.50, item.getCost(), DELTA);
    }
    @Test
    public void toppingsCanBeStacked() {
        FoodItem item = new Onions(new Cheese(new Burger()));

        assertEquals("Burger, cheese, onions", item.getDescription());
        assertEquals(6.25, item.getCost(), DELTA);
    }
    @Test
    public void orderAddsItemsAndCalculatesTotal() {
        Order order = new Order();

        order.addItem(new Cheese(new Burger()));
        order.addItem(new Fries());

        assertEquals(8.25, order.calculateTotal(), DELTA);
    }
    @Test
    public void loyaltyStatusReturnsStatusAndAppliesDiscount() {
        LoyaltyStatus loyalty = new LoyaltyStatus("Gold");

        assertEquals("Gold", loyalty.getStatus());
        assertEquals(8.50, loyalty.applyDiscount(10.00), DELTA);
    }

}
