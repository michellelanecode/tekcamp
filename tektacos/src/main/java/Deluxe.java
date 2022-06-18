

public class Deluxe extends Entree{

    public static void createEntree() {
        Entree newDeluxe = new Entree();
        CreateOrder.newOrder.entreeType = Entrees.DELUXE;
        if(TekTacos.currentCustomer.askForDeluxeToppings()){
            CreateOrder.newOrder.toppings.add(Toppings.ONION);
            CreateOrder.newOrder.toppings.add(Toppings.CHEESE);
            CreateOrder.newOrder.toppings.add(Toppings.LETTUCE);
            CreateOrder.newOrder.toppings.add(Toppings.TOMATO);
            newDeluxe.createEntree(2);
        } else {
            newDeluxe.createEntree(6);
        }

    }
}
