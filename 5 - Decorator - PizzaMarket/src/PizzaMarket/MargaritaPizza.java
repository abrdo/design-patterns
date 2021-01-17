package PizzaMarket;

public class MargaritaPizza extends Pizza {
    private char size;

    public MargaritaPizza(char sizeP){
        size = sizeP;
        if(size == 'S') cost = 800;
        if(size == 'M') cost = 900;
        if(size == 'L') cost = 1000;

        description = "Margarita-" + size;
    }

}
