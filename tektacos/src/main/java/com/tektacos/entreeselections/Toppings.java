package Customer_Inputs;

public enum Toppings {
    LETTUCE(0.10),
    TOMATO(0.10),
    ONION(0.10),
    CHEESE(1.25),
    SALSA(0.75),
    CILANTRO(0.10),
    JALEPENO(0.75),

    NOTOPPINGS(0.00);


    public final double cost;

     Toppings(double cost){
        this.cost = cost;
    }
}
