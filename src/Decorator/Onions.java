package Decorator;

public class Onions extends ToppingDecorator{

    public Onions(FoodItem foodItem) {
        super(foodItem);
    }

    @Override
    public String getDescription() {
        return foodItem.getDescription() + ", onions";
    }

    @Override
    public double getCost() {
        return foodItem.getCost() + 0.50;
    }
}
