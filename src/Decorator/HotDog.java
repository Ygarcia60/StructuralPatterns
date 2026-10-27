package Decorator;

public class HotDog implements FoodItem{

    @Override
    public String getDescription() {
        return "HotDog";
    }

    @Override
    public double getCost() {
        return 3.50;
    }
}
