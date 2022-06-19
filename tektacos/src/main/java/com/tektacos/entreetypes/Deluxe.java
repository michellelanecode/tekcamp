package com.tektacos.entreetypes;

import com.tektacos.main.CreateOrder;
import com.tektacos.TekTacos;
import com.tektacos.ordertypes.Entree;

public class Deluxe extends Entree {

    public void createEntree() {
        Entree newDeluxe = new Entree();
        CreateOrder.newOrder.entreeType = Entrees.DELUXE;
        if(TekTacos.currentCustomer.askForDeluxeToppings()){
            TekTacos.currentRequest.addStandardDeluxeToppings();
            newDeluxe.createEntree(2);
        } else {
            newDeluxe.createEntree(6);
        }
    }
}
