package com.tektacos.main;


import com.tektacos.TekTacos;
import com.tektacos.entreeselections.Proteins;
import com.tektacos.entreetypes.Basic;
import com.tektacos.entreetypes.Deluxe;
import com.tektacos.entreetypes.Entrees;
import com.tektacos.entreetypes.Veggie;
import com.tektacos.financial.Order;
import com.tektacos.ordertypes.Sides;

public class CreateOrder {

    public static Order newOrder = new Order();

    public void chooseTortilla(String tortillaChoice){
        switch(tortillaChoice){
            case "f":
                newOrder.tortillaType = Customer_Inputs.Tortilla.FLOUR;
                break;
            case "c":
                newOrder.tortillaType = Customer_Inputs.Tortilla.CORN;
                break;
        }
    }

    public void chooseProtein(String protein){
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
    public static void createDrink(){
        Order_Types.Drinks newDrink = new Order_Types.Drinks();
        String choice = TekTacos.currentCustomer.getDrinkChoice();
        newOrder.drinkType = newDrink.returnDrinkChoice(choice);
    }

    public void createSide(){
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
        newOrder.toppings.add(Customer_Inputs.Toppings.CHEESE);
        newOrder.toppings.add(Customer_Inputs.Toppings.ONION);
        newOrder.toppings.add(Customer_Inputs.Toppings.LETTUCE);
        newOrder.toppings.add(Customer_Inputs.Toppings.TOMATO);
    }
    public void addToppings(String toppingChoice){
        switch(toppingChoice){
            case "l":
                newOrder.toppings.add(Customer_Inputs.Toppings.LETTUCE);
                break;
            case "t":
                newOrder.toppings.add(Customer_Inputs.Toppings.TOMATO);
                break;
            case "o":
                newOrder.toppings.add(Customer_Inputs.Toppings.ONION);
                break;
            case "cs":
                newOrder.toppings.add(Customer_Inputs.Toppings.CHEESE);
                break;
            case "s":
                newOrder.toppings.add(Customer_Inputs.Toppings.SALSA);
                break;
            case "ct":
                newOrder.toppings.add(Customer_Inputs.Toppings.CILANTRO);
                break;
            case "j":
                newOrder.toppings.add(Customer_Inputs.Toppings.JALEPENO);
                break;

        }
    }


}
