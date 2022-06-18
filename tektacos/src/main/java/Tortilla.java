public enum Tortilla {
    FLOUR(.50),
    CORN(.25),

    NOTORTILLA(0.00);
    public final double cost;

    Tortilla(double cost){
        this.cost = cost;
    }
}
