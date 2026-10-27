package Decorator;

public class Ketchup extends ToppingDecorator{

    public Ketchup(FoodItem foodItem) {
        super(foodItem);
    }

    @Override
    public String getDescription() {
        return foodItem.getDescription() + ", ketchup";
    }

    @Override
    public double getCost() {
        return foodItem.getCost() + 0.25;
    }
}
