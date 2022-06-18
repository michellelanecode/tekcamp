public class CreateOrder {

    static Order newOrder = new Order();

    public  void chooseTortilla(String tortillaChoice){
        switch(tortillaChoice){
            case "f":
                newOrder.tortillaType = Tortilla.FLOUR;
                break;
            case "c":
                newOrder.tortillaType = Tortilla.CORN;
                break;
        }
    }

    public  void chooseProtein(String protein){
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
        Drinks newDrink = new Drinks();
        String choice = TekTacos.currentCustomer.getDrinkChoice();
        newOrder.drinkType = newDrink.returnDrinkChoice(choice);
    }

    public  void createSide(){
        Sides newSide = new Sides();
        String side = TekTacos.currentCustomer.getSideChoice();
        newOrder.sideType = newSide.returnSide(side);
    }

    public void createEntrees(String entreeType){
        switch (entreeType){
            case "b":
                new Basic().createEntree();
                break;
            case "d":

               new Deluxe().createEntree();
                break;
            case "v":
                new Veggie().createEntree();
                break;
            case "c":
                newOrder.entreeType = Entrees.CYA;
                new Basic().createEntree();
        }
    }

    public void createCombo(){
        String entreeChoice = TekTacos.currentCustomer.getEntreeChoice();
        createEntrees(entreeChoice);
    }


    public void createOrder(String orderType){
        switch (orderType) {
            case "e":
                String entreeChoice =  TekTacos.currentCustomer.getEntreeChoice();;
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
    public void addToppings(String toppingChoice){
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
