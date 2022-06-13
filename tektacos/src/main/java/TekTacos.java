import java.util.Scanner;

public class TekTacos {
    static Scanner sc = new Scanner(System.in);
    static String drinkType = "No Drink";
    static String entreeType = "No Entree";
    static String sideType = "No Side";

    static String drinksMenu = "Drink menu: water | tea | soda";
    static String sidesMenu = " Sides menu: chips/queso | chips/salsa | fries";
    static String comboMenu = "Taco Entree Choice plus Toppings, Side and Drink";

    public static void showEntreeMenu(){
        System.out.println("Entree menu ");
        System.out.println("Basic - Tortilla (flour or corn) Protein (beef, chicken, steak, pork, black beans) and 4 toppings");
        System.out.println("Deluxe - Basic plus lettuce, tomato, onion, cheese and 2 additional toppings ");
        System.out.println("Veggie - Tortilla (flour or corn) Black beans and 4 toppings ");
        System.out.println("Toppings menu:");
        System.out.println("Lettuce, Tomato, Cheese, Salsa, Cilantro, Jalapeno, Onion");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to TEKTacos!");
        System.out.println("******** :-) :-) :-) :-) *******");
        System.out.println("What you like an Entree, Combo, Drink, or Side?");
        String baseOrder = sc.nextLine();

        switch (baseOrder) {
            case "entree":
                showEntreeMenu();
                Entree newEntree = new Entree();
                entreeType = newEntree.getEntreeType();
                System.out.println("Would you like a side? y or n");
                String sides = sc.nextLine();
                if (sides.equals("y")) {
                    System.out.println(sidesMenu);
                    Sides newSide = new Sides();
                    sideType = newSide.getSide();
                }
                System.out.println("Would you like a drink? y or n");
                String drink = sc.nextLine();
                if (drink.equals("y")) {
                    System.out.println(drinksMenu);
                    Drinks newDrink = new Drinks();
                    drinkType = newDrink.getDrinkChoice();
                }
                break;
            case "combo":
                System.out.println(comboMenu);
                Combo newCombo = new Combo();
                entreeType = "Combo type " + newCombo.getEntreeType();
                drinkType = "Combo drink " + newCombo.getDrinkChoice();
                sideType = "Combo side " + newCombo.getSideChoice();
                break;
            case "side":
                System.out.println(sidesMenu);
                Sides newSide = new Sides();
                sideType = newSide.getSide();
                break;
            case "drink":
                System.out.println(drinksMenu);
                Drinks newDrink = new Drinks();
                drinkType = newDrink.getDrinkChoice();
                break;
        }

        System.out.println("____________________________________");
        System.out.println("Completing your order.....");
        System.out.println("____________________________________");
        System.out.println("** COPY RECEIPT******");
        System.out.println("****** TEKTACOS POS ******* ");
        System.out.println("____________________________________");
        System.out.println("1. " + entreeType);
        System.out.println("2. " + sideType);
        System.out.println("3. " + drinkType);
        System.out.println("____________________________________");
        System.out.println("Total");
        System.out.println("Free!");
        System.out.println("____________________________________");
        System.out.println("THANKS FOR CHOOSING TEKTACOS");

    }
}
