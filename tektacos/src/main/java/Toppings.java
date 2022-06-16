public enum Toppings {
    LETTUCE(1),
    TOMATO(1),
    ONION(1),
    CHEESE(2),
    SALSA(1),
    CILANTRO(1),
    JALEPENO(2);


    public final int cost;

     Toppings(int cost){
        this.cost = cost;
    }
}
