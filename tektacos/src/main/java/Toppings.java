public enum Toppings {
    LETTUCE(.50),
    TOMATO(.50),
    ONION(.50),
    CHEESE(1.50),
    SALSA(.50),
    CILANTRO(.50),
    JALEPENO(.75);

    public final double cost;

    Toppings(double cost){
        this.cost = cost;
    }


}


