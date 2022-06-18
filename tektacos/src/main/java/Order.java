import java.util.ArrayList;

public class Order {

    static Drinks.DrinkChoices drinkType = Drinks.DrinkChoices.NODRINK;
    static Entree.Entrees entreeType = Entree.Entrees.NOENTREE;

    static Proteins proteinType = Proteins.NOPROTEIN;

    static Tortilla tortillaType = Tortilla.NOTORTILLA;
    static Sides.sideChoices sideType = Sides.sideChoices.NOSIDE;
    static ArrayList<Toppings> toppings = new ArrayList<Toppings>();

    static double total = 0.00;


}
