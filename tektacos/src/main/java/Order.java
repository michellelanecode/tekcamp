import java.util.ArrayList;

public class Order {

    static Drinks.DrinkChoices drinkType = Drinks.DrinkChoices.NODRINK;
    static Entree.Entrees entreeType = Entree.Entrees.NOENTREE;

    static Proteins proteinType = Proteins.NOPROTEIN;

    static Tortilla tortillaType = Tortilla.NOTORTILLA;
    static Sides.sideChoices sideType = Sides.sideChoices.NOSIDE;
    static ArrayList<Toppings> toppings = new ArrayList<>();

    static double total = 0.00;
    public static double calculateToppings() {
        double totalToppings = 0;
        for (Toppings i : Order.toppings) {
            totalToppings += i.cost;
        }
        return totalToppings;
    }
    public static void calculateTotal(){Order.total += Order.entreeType.cost + Order.proteinType.cost + Order.tortillaType.cost + Order.sideType.cost + Order.drinkType.cost + Order.calculateToppings();}
}
