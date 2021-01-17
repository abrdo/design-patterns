package PizzaMarket;

public class NeapolitanPizza extends Pizza {
    char size;

    NeapolitanPizza(char sizeP){
        size = sizeP;
        if(size == 'S') cost = 820;
        if(size == 'M') cost = 920;
        if(size == 'L') cost = 1020;

        description = "Neapolitan-" + size;
    }

}
