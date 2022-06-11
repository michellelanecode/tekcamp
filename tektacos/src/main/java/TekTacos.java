import java.util.Scanner;

public class TekTacos {
    static Scanner sc = new Scanner(System.in);
    static String drinkType = "no drink";
    static String comboType = "no combo";
    static String entreeType = "no entree";
    static String sideType = "no side";

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
        if (baseOrder.equals("entree")){
        Entree newEntree = new Entree();
        entreeType = newEntree.getEntreeType();

        } else if (baseOrder.equals("combo")){
            //create a combo component
            System.out.println("What kind of entree would you like?");
            String comboType = sc.nextLine();
            System.out.println("What kind of tortilla would you like?");
            String comboTortillaType = sc.nextLine();
            System.out.println("What kind of protein would you like?");
            String comboProteinType = sc.nextLine();
            System.out.println("What toppings would you like?");
            String comboToppings = sc.nextLine();
        }

        else if(baseOrder.equals("side")){
            System.out.println("Would you like a side? y or n");
            String sides = sc.nextLine();
            if (sides.equals("y")){
                Sides newSide = new Sides();
                sideType = newSide.getSide();
            }
        }

        else if(baseOrder.equals("drink")){
            //create a ask for drink function and drink component
        }


        System.out.println("Would you like a side? y or n");
        String sides = sc.nextLine();
        if (sides.equals("y")){
           Sides newSide = new Sides();
           sideType = newSide.getSide();
        }

       // create an ask for drink function that will ask for drink and if answer is yet return one, to avoid repeating code


        System.out.println("____________________________________");
        System.out.println("Completing your order.....");
        System.out.println("____________________________________");
        System.out.println("** COPY RECEIPT******");
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
