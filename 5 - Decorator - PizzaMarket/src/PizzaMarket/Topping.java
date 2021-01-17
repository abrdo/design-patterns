package PizzaMarket;

public class Topping extends Pizza {
    protected Pizza basePizza;

    public Topping(Pizza basePizzaP){
        basePizza = basePizzaP;
    }

    @Override
    public String getDescription() {
        return basePizza.getDescription() + " with " + super.getDescription();
    }

    @Override
    public int getCost() {
        return basePizza.getCost() + super.getCost();
    }
}
