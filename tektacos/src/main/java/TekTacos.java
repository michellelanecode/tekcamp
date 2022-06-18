import java.util.Scanner;

public class TekTacos {
     static Scanner sc = new Scanner(System.in);

    static double total = 0;
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

    //build meal methods
    public static String getTortilla(){
        System.out.println("What kind of tortilla would you like? Flour(f) or Corn (c)");
        return sc.nextLine();
    }

    public static void chooseTortilla(String tortillaChoice){
        switch(tortillaChoice){
            case "f":
        Order.tortillaType = Tortilla.FLOUR;
        break;
            case "c":
                Order.tortillaType = Tortilla.CORN;
                break;
        }

        Order.tortillaType = Tortilla.NOTORTILLA;
    }
    public static String getProtein(){
        System.out.println("What kind of protein would you like? Beef(b), Chicken(c), Black Beans(bb), Shredded Pork(p), Steak(s)");
        return  sc.nextLine();
    }

    public static void chooseProtein(String protein){
        switch(protein){
            case "b":
                Order.proteinType = Proteins.BEEF;
                break;

            case "c":
                Order.proteinType = Proteins.CHICKEN;
                break;

            case "bb":
                Order.proteinType = Proteins.BLACKBEANS;

            case "p":
                Order.proteinType = Proteins.SHREDDEDPORK;
                break;

            case "s":
                Order.proteinType = Proteins.STEAK;
        }

        Order.proteinType = Proteins.NOPROTEIN;
    }




    public static String askForToppings(int toppingCount){
        System.out.println("What toppings would you like? You have " + toppingCount + "remaining");
        System.out.println("Toppings: Lettuce(l), Tomato(t), Cheese(cs), Salsa(s), Cilantro(ct), Jalapeno(j), Onion(o)");
        return sc.nextLine();
    }
    public static Boolean askForDeluxeToppings(){
        System.out.println("Does customer want standard toppings of lettuce, tomato, onion, cheese ? y or n");
        return sc.nextLine().equals("y");
    }

    public void addStandardDeluxeToppings(){
        Order.toppings.add(Toppings.CHEESE);
        Order.toppings.add(Toppings.ONION);
        Order.toppings.add(Toppings.LETTUCE);
        Order.toppings.add(Toppings.TOMATO);
    }
    public static void addToppings(String toppingChoice){
        switch(toppingChoice){
            case "l":
               Order.toppings.add(Toppings.LETTUCE);
                break;
            case "t":
                 Order.toppings.add(Toppings.TOMATO);
                break;
            case "o":
               Order.toppings.add(Toppings.ONION);
                break;
            case "cs":
              Order.toppings.add(Toppings.CHEESE);
                break;
            case "s":
               Order.toppings.add(Toppings.SALSA);
                break;
            case "ct":
               Order.toppings.add(Toppings.CILANTRO);
                break;
            case "j":
            Order.toppings.add(Toppings.JALEPENO);
            break;

        }
       Order.toppings.add(Toppings.NOTOPPINGS);
    }


    public static Boolean askForDrink(){
        System.out.println("Would you like a drink? y or n");
        return sc.nextLine().equals("y");
    }
    static void createDrink(){
        System.out.println("Drinks menu:");
        System.out.println("Drink menu: water(w) | tea(t) | soda(s)");
        System.out.println("What kind of drink would you like?");
        String choice = sc.nextLine();
        Drinks newDrink = new Drinks();
        Order.drinkType = newDrink.returnDrinkChoice(choice);
    }

    public static Boolean askForSide(){
        System.out.println("Would you like a side? y or n");
        return sc.nextLine().equals("y");
    }
    public static void createSide(){
        System.out.println("Sides menu:");
        System.out.println("Sides menu: chips/queso (cq) | chips/salsa(cs) | fries (f)");
        System.out.println("What kind of side would you like?");
        String side = sc.nextLine();
        Sides newSide = new Sides();
        Order.sideType = newSide.returnSide(side);
    }
    public static String getEntreeChoice(){
        showEntreeMenu();
        System.out.println("What type of entree would you like? Basic(b), Deluxe(d), Veggie(v), CreateYourOwn (c)");
        return sc.nextLine();
    }

    public static void createEntrees(String entreeType){
        switch (entreeType){
            case "b":
                Basic.createEntree();
                break;
            case "d":
                Deluxe.createEntree();
                break;
            case "v":
                Veggie.createEntree();
                break;
            case "c":
                Entree.createEntree(4);
        }
    }
    public static void createCombo(){
        System.out.println(comboMenu);
        String entreeChoice = getEntreeChoice();
        createEntrees(entreeChoice);
        createSide();
        createDrink();
    }

    public static String askForOrder(){
        System.out.println("Welcome to TEKTacos!");
        System.out.println("******** :-) :-) :-) :-) *******");
        System.out.println("Would you like an Entree(e), Combo(c), Drink(d), or Side(s)?");
        return sc.nextLine();
    }
    public static void createOrder(String orderType){
        switch (orderType) {
            case "e":
              String entreeChoice =  getEntreeChoice();
                createEntrees(entreeChoice);
                break;
            case "c":
               createCombo();
                break;
            case "s":
               createSide();
                break;
            case "d":
               createDrink();
                break;
        }
    }

        public void main(String[] args) {
         String orderType = askForOrder();
         createOrder(orderType);
         Receipt.calculateTotal();
         Receipt.returnReceipt();
    }
}
