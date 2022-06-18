import java.util.ArrayList;

public class Order {

    static Drinks.DrinkChoices drinkType;
    static Entree.Entrees entreeType;

    static Proteins proteinType;

    static Tortilla tortillaType;
    static Sides.sideChoices sideType;
    static ArrayList<Toppings> toppings = new ArrayList<Toppings>();

    static double total = 0.00;
    public static double calculateToppings() {
        double totalToppings = 0;
        for (Toppings i : Order.toppings) {
            totalToppings += i.cost;
        }
        return totalToppings;
    }
    public static void calculateTotal(){Order.total += Order.entreeType.cost + Order.proteinType.cost + Order.tortillaType.cost + Order.sideType.cost + Order.calculateToppings();};
}
