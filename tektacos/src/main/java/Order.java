import java.util.ArrayList;

public class Order {

     Drinks.DrinkChoices drinkType = Drinks.DrinkChoices.NODRINK;
     Entrees entreeType = Entrees.NOENTREE;

     Proteins proteinType = Proteins.NOPROTEIN;

     Tortilla tortillaType = Tortilla.NOTORTILLA;
     Sides.sideChoices sideType = Sides.sideChoices.NOSIDE;
     ArrayList<Toppings> toppings = new ArrayList<>();

     Calculator mealCalculator = new Calculator();

    static double total = 0.00;


}
