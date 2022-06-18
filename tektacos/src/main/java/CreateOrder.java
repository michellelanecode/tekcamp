import java.util.Scanner;

public class CreateOrder {

    static Order newOrder = new Order();

    public static void chooseTortilla(String tortillaChoice){
        switch(tortillaChoice){
            case "f":
                newOrder.tortillaType = Tortilla.FLOUR;
                break;
            case "c":
                newOrder.tortillaType = Tortilla.CORN;
                break;
        }

    }

    public static void chooseProtein(String protein){
        switch(protein){
            case "b":
                newOrder.proteinType = Proteins.BEEF;
                break;

            case "c":
                newOrder.proteinType = Proteins.CHICKEN;
                break;

            case "bb":
                newOrder.proteinType = Proteins.BLACKBEANS;

            case "p":
                newOrder.proteinType = Proteins.SHREDDEDPORK;
                break;

            case "s":
                newOrder.proteinType = Proteins.STEAK;
        }

    }
    static void createDrink(){
        System.out.println("Drinks menu:");
        System.out.println("Drink menu: water(w) | tea(t) | soda(s)");
        System.out.println("What kind of drink would you like?");
        String choice = sc.nextLine();
        Drinks newDrink = new Drinks();
        newOrder.drinkType = newDrink.returnDrinkChoice(choice);
    }

    public static void createSide(){
        System.out.println("Sides menu:");
        System.out.println("Sides menu: chips/queso (cq) | chips/salsa(cs) | fries (f)");
        System.out.println("What kind of side would you like?");
        String side = sc.nextLine();
        Sides newSide = new Sides();
        newOrder.sideType = newSide.returnSide(side);
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
                newOrder.entreeType = Entrees.CYA;
                Entree.createEntree(4);
        }
    }

    public static void createCombo(){
        System.out.println(comboMenu);
        String entreeChoice = getEntreeChoice();
        createEntrees(entreeChoice);
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

    public void addStandardDeluxeToppings(){
        newOrder.toppings.add(Toppings.CHEESE);
        newOrder.toppings.add(Toppings.ONION);
        newOrder.toppings.add(Toppings.LETTUCE);
        newOrder.toppings.add(Toppings.TOMATO);
    }
    public static void addToppings(String toppingChoice){
        switch(toppingChoice){
            case "l":
                newOrder.toppings.add(Toppings.LETTUCE);
                break;
            case "t":
                newOrder.toppings.add(Toppings.TOMATO);
                break;
            case "o":
                newOrder.toppings.add(Toppings.ONION);
                break;
            case "cs":
                newOrder.toppings.add(Toppings.CHEESE);
                break;
            case "s":
                newOrder.toppings.add(Toppings.SALSA);
                break;
            case "ct":
                newOrder.toppings.add(Toppings.CILANTRO);
                break;
            case "j":
                newOrder.toppings.add(Toppings.JALEPENO);
                break;

        }
    }


}
