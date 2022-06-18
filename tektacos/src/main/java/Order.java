import java.util.ArrayList;

public class Order {

     Drinks.DrinkChoices drinkType = Drinks.DrinkChoices.NODRINK;
     Entrees entreeType = Entrees.NOENTREE;

     Proteins proteinType = Proteins.NOPROTEIN;

     Tortilla tortillaType = Tortilla.NOTORTILLA;
     Sides.sideChoices sideType = Sides.sideChoices.NOSIDE;
     ArrayList<Toppings> toppings = new ArrayList<>();


    double mealTotal = new Calculator().calculateMeal();

    double toppingsTotal = new Calculator().calculateToppings();

    double allTotal = new Calculator().calculateTotal();
    static double total = 0.00;


}
