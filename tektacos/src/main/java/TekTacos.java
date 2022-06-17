import java.util.Scanner;

public class TekTacos {
    static Scanner sc = new Scanner(System.in);
    static String drinkType = "NO DRINK";
    static String entreeType = "NO ENTREE";
    static String sideType = "NO SIDE";

    static double total = 0;
    static String drinksMenu = "Drink menu: water(w) | tea(t) | soda(s)";
    static String sidesMenu = "Sides menu: chips/queso (cq) | chips/salsa(cs) | fries (f)";
    static String comboMenu = "Combo includes Taco Entree Choice plus Toppings, Side and Drink";

    static String proteinMenu = "Proteins: beef(b), chicken(c), steak(s), pork(p), black beans(bb) ";

    static String toppingsMenu = "Lettuce(l), Tomato(t), Cheese(cs), Salsa(s), Cilantro(ct), Jalapeno(j), Onion(o)";

    public static void showEntreeMenu(){
        System.out.println("Entree menu ");
        System.out.println("Basic - Tortilla (flour or corn) Protein ( and 4 toppings");
        System.out.println("Deluxe - Basic plus lettuce, tomato, onion, cheese and 2 additional toppings ");
        System.out.println("Veggie - Tortilla (flour or corn) Black beans and 4 toppings ");
        System.out.println("Proteins:");
        System.out.println(proteinMenu);
        System.out.println("Toppings menu:");
        System.out.println(toppingsMenu);

    }

    public static void main(String[] args) {
        System.out.println("Welcome to TEKTacos!");
        System.out.println("******** :-) :-) :-) :-) *******");
        System.out.println("What you like an Entree(e), Combo(c), Drink(d), or Side(s)?");
        String baseOrder = sc.nextLine();

        switch (baseOrder) {
            case "e":
                showEntreeMenu();
                Entree newEntree = new Entree();
                entreeType = newEntree.getEntreeType();
                TekTacos.total += newEntree.cost;
                System.out.println("Would you like a side? y or n");
                String sides = sc.nextLine();
                if (sides.equals("y")) {
                    System.out.println(sidesMenu);
                    Sides newSide = new Sides();
                     newSide.getSide();
                     sideType = newSide.returnSide();

                }
                System.out.println("Would you like a drink? y or n");
                String drink = sc.nextLine();
                if (drink.equals("y")) {
                    System.out.println(drinksMenu);
                    Drinks newDrink = new Drinks();
                    newDrink.getDrinkChoice();
                    drinkType = newDrink.returnDrinkChoice();

                }
                break;
            case "c":
                System.out.println(comboMenu);
                Combo newCombo = new Combo();
                entreeType = "Combo type: " + newCombo.getEntreeType();
                drinkType = "Combo drink: " + newCombo.getDrinkChoice();
                sideType = "Combo side: " + newCombo.getSideChoice();
                break;
            case "s":
                System.out.println(sidesMenu);
                Sides newSide = new Sides();
                newSide.getSide();
                sideType = newSide.returnSide();

                break;
            case "d":
                System.out.println(drinksMenu);
                Drinks newDrink = new Drinks();
                newDrink.getDrinkChoice();
                drinkType = newDrink.returnDrinkChoice();

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
        System.out.println("Total:");
        System.out.println("$" + TekTacos.total);
        System.out.println("____________________________________");
        System.out.println("THANKS FOR CHOOSING TEKTACOS");

    }
}
