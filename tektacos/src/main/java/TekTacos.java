import java.util.Scanner;

public class TekTacos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
        Entree order;
        if (baseOrder.equals("Entree")){
            System.out.println("What is your entree type? Basic, Deluxe, or Veggie");
            String entreeType = sc.nextLine();
            System.out.println("What kind of tortilla would you like?");
            String tortillaType = sc.nextLine();
            System.out.println("What kind of protein would you like?");
            String proteinType = sc.nextLine();
            System.out.println("What toppings would you like?");
            String toppings = sc.nextLine();
        } else if (baseOrder.equals("Combo")){
            System.out.println("What kind of entree would you like?");
            String comboType = sc.nextLine();
            System.out.println("What kind of tortilla would you like?");
            String comboTortillaType = sc.nextLine();
            System.out.println("What kind of protein would you like?");
            String comboProteinType = sc.nextLine();
            System.out.println("What toppings would you like?");
            String comboToppings = sc.nextLine();
        }

        System.out.println("Drink? Y or N");
        String drinkChoice = sc.nextLine();
        String drinkType;
        if (drinkChoice.equals("y")){
            System.out.println("What kind of drink would you like?");
            drinkType = sc.nextLine();
        }
        System.out.println("Would you like a side? Y/N");
        String sides = sc.nextLine();
        String sideChoice;
        if (sides.equals("Y")){
            System.out.println("What kind of side would you like");
            sideChoice = sc.nextLine();
        }
        System.out.println("____________________________________");
        System.out.println("Completing your order.....");
        System.out.println("____________________________________");


    }
}
