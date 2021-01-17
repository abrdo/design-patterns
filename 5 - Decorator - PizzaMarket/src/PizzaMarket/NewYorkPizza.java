package PizzaMarket;

public class NewYorkPizza extends Pizza {
    char size;

    NewYorkPizza(char sizeP){
        size = sizeP;
        if(size == 'S') cost = 810;
        if(size == 'M') cost = 910;
        if(size == 'L') cost = 1010;

        description = "NewYork-" + size;
    }

}
