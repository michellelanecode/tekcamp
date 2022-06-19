package com.tektacos.ordertypes;


import com.tektacos.main.CreateOrder;
import com.tektacos.main.CustomerInfo;
import com.tektacos.main.TekTacos;

public class Entree  {

    CreateOrder currentRequest = TekTacos.currentRequest;
    CustomerInfo currentCustomer = TekTacos.currentCustomer;
    public void createEntree(int toppingChoices) {
        String tortillaChoice = currentCustomer.getTortilla();
        currentRequest.chooseTortilla(tortillaChoice);
        String proteinChoice = currentCustomer.getProtein();
        currentRequest.chooseProtein(proteinChoice);
        while (toppingChoices > 0) {
            String toppingChoice = currentCustomer.askForToppings(toppingChoices);
            currentRequest.addToppings(toppingChoice);
            toppingChoices--;
        }
        if (currentCustomer.askForSide()) {
            currentRequest.createSide();
        } else {
            currentRequest.newOrder.sideType = sideChoices.NOSIDE;
        }

        if (currentCustomer.askForDrink()) {
            currentRequest.createDrink();
        } else {
            currentRequest.newOrder.drinkType = Order_Types.Drinks.DrinkChoices.NODRINK;
        }
    }

}
