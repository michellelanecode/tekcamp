package com.tektacos.entreetypes;

import com.tektacos.main.CreateOrder;
import com.tektacos.ordertypes.Entree;;
public class Basic extends Entree {
    public void createEntree(){
        CreateOrder.newOrder.entreeType =  Entrees.BASIC;
        Entree newBasic = new Entree();
        newBasic.createEntree(4);
    }

}
