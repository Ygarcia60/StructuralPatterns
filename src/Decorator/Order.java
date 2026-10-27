package Decorator;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final List<FoodItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(FoodItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0.0;

        for (FoodItem item: items) {
            total += item.getCost();
        }
        return total;
    }

    public void displayItems() {
        for (FoodItem item: items) {
            System.out.printf("%s: $%.2f%n", item.getDescription(),item.getCost());
        }
    }
}
