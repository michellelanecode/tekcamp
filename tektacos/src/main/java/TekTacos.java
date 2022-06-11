import java.util.Scanner;

public class TekTacos {
    static Scanner sc = new Scanner(System.in);
    static String drinkType = "no drink";
    static String comboType;
    static String entreeType;
    static String sideType = "no side";
    String completeOrder;
    public static void createEntree(String entree, String tortilla, String protein, String toppings){
            Entree entreeOrder = new Entree(entree, tortilla, protein, toppings);
            entreeType = entreeOrder.returnOrder();
    };
    public static void createcombo(String entreeType, String tortilla, String protein, String toppings){

    };

    public static String createDrink(String drink){
        return "test";
    };
    public static String createSide(String side){
        return "test";
    };

    public static String askForDrink(){
        System.out.println("Drink? Y or N");
        String answer = sc.nextLine();

        if (answer.equals('y')){
                System.out.println("What kind of drink would you like?");
               drinkType = sc.nextLine();
        }
        return "test";
    };

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

        if (baseOrder.equals("Entree")){

//            createEntree(entreeType, tortillaType, proteinType, toppings);
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
        System.out.println("Would you like a side? Y/N");
        String sides = sc.nextLine();
        String sideChoice;
        if (sides.equals("Y")){
            System.out.println("What kind of side would you like");
            sideType = sc.nextLine();
        }
        System.out.println("____________________________________");
        System.out.println("Completing your order.....");
        System.out.println("____________________________________");
        System.out.print("** COPY RECEIPT******");
        System.out.println("1." + entreeType);
        System.out.println("2." + sideType);
        System.out.println("3." + drinkType);
        System.out.println("____________________________________");
        System.out.println("Total");
        System.out.println("Free!");
        System.out.println("____________________________________");

    }
}
