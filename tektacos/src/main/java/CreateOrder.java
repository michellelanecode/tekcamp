public class CreateOrder {

    public static void chooseTortilla(String tortillaChoice){
        switch(tortillaChoice){
            case "f":
                Order.tortillaType = Tortilla.FLOUR;
                break;
            case "c":
                Order.tortillaType = Tortilla.CORN;
                break;
        }

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

    }
    static void createDrink(){
        System.out.println("Drinks menu:");
        System.out.println("Drink menu: water(w) | tea(t) | soda(s)");
        System.out.println("What kind of drink would you like?");
        String choice = sc.nextLine();
        Drinks newDrink = new Drinks();
        Order.drinkType = newDrink.returnDrinkChoice(choice);
    }

    public static void createSide(){
        System.out.println("Sides menu:");
        System.out.println("Sides menu: chips/queso (cq) | chips/salsa(cs) | fries (f)");
        System.out.println("What kind of side would you like?");
        String side = sc.nextLine();
        Sides newSide = new Sides();
        Order.sideType = newSide.returnSide(side);
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
                Order.entreeType = Entrees.CYA;
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
    }


}
