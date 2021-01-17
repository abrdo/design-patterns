package PizzaMarket;

public class PizzaMarket {

    public static void main(String[] args) {
        Pizza pizza = new MargaritaPizza('S');
        pizza = new TomatoSauce(pizza);

        Pizza pizza2 = new NewYorkPizza('L');
        pizza2 = new Olive(pizza2);
        pizza2 = new Mozzarella(pizza2);

        Pizza pizza3 = new NeapolitanPizza('L');
        pizza3 = new TomatoSauce(pizza3);
        pizza3 = new Olive(pizza3);
        pizza3 = new Mozzarella(pizza3);





        System.out.println("\nDescription: " + pizza.getDescription());
        System.out.println("Cost: " + pizza.getCost());

        System.out.println("Description: " + pizza2.getDescription());
        System.out.println("Cost: " + pizza2.getCost());

        System.out.println("Description: " + pizza3.getDescription());
        System.out.println("Cost: " + pizza3.getCost());
    }
}
