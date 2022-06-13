import java.util.Scanner;

public class TekTacos {
    static Scanner sc = new Scanner(System.in);
    static String drinkType = "No Drink";
    static String entreeType = "No Entree";
    static String sideType = "No Side";

    public static void main(String[] args) {
        System.out.println("Welcome to TEKTacos! Please look at our menu");
        System.out.println("Entree: ");
        System.out.println("Basic - Tortilla (flour or corn) Protein (beef, chicken, steak, pork, black beans) and 4 toppings");
        System.out.println("Deluxe - Basic plus lettuce, tomato, onion, cheese and 2 additional toppings ");
        System.out.println("Veggie - Tortilla (flour or corn) Black beans and 4 toppings ");
        System.out.println("Combo:");
        System.out.println("Taco Entree Choice plus Toppings, Side and Drink");
        System.out.println("Toppings:");
        System.out.println("Lettuce, Tomato, Cheese, Salsa, Cilantro, Jalapeno, Onion");
        System.out.println("Sides:");
        System.out.println("Chips and Salsa");
        System.out.println("Chips and Queso");
        System.out.println("Fries");
        System.out.println("Drinks");
        System.out.println("Soda"); System.out.println("Tea"); System.out.println("Water");
        System.out.println("_________________________");
        System.out.println("What you like an Entree, Combo, Drink, or Side?");
        String baseOrder = sc.nextLine();


        switch (baseOrder) {
            case "entree":
                Entree newEntree = new Entree();
                entreeType = newEntree.getEntreeType();
                System.out.println("Would you like a side? y or n");
                String sides = sc.nextLine();
                if (sides.equals("y")) {
                    Sides newSide = new Sides();
                    sideType = newSide.getSide();
                }
                System.out.println("Would you like a drink? y or n");
                String drink = sc.nextLine();
                if (drink.equals("y")) {
                    Drinks newDrink = new Drinks();
                    drinkType = newDrink.getDrinkChoice();
                }
                break;
            case "combo":
                Combo newCombo = new Combo();
                entreeType = newCombo.getEntreeType();
                drinkType = newCombo.getDrinkChoice();
                sideType = newCombo.getSideChoice();
                break;
            case "side":
                Sides newSide = new Sides();
                sideType = newSide.getSide();
                break;
            case "drink":
                Drinks newDrink = new Drinks();
                drinkType = newDrink.getDrinkChoice();
                break;
        }

        System.out.println("____________________________________");
        System.out.println("Completing your order.....");
        System.out.println("____________________________________");
        System.out.println("** COPY RECEIPT******");
        System.out.println("1." + entreeType);
        System.out.println("2. " + sideType);
        System.out.println("3. " + drinkType);
        System.out.println("____________________________________");
        System.out.println("Total");
        System.out.println("Free!");
        System.out.println("____________________________________");
        System.out.println("THANKS FOR CHOOSING TEKTACOS");

    }
}
