package Decorator;

public abstract class ToppingDecorator implements FoodItem {

    protected final FoodItem foodItem;

    public ToppingDecorator(FoodItem foodItem) {
        this.foodItem = foodItem;
    }
}
