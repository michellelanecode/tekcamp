

public class Deluxe extends Entree{

    public static void createEntree() {
        Order.entreeType = Entrees.DELUXE;
        if(TekTacos.askForDeluxeToppings()){
            Order.toppings.add(Toppings.ONION);
            Order.toppings.add(Toppings.CHEESE);
            Order.toppings.add(Toppings.LETTUCE);
            Order.toppings.add(Toppings.TOMATO);
            Entree.createEntree(2);
        } else {
            Entree.createEntree(6);
        }

    }
}
