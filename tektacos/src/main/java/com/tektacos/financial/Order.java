package com.tektacos.financial;


import com.tektacos.entreeselections.Proteins;
import com.tektacos.entreetypes.Entrees;
import com.tektacos.ordertypes.sideChoices;

import java.util.ArrayList;

public class Order {

     public Order_Types.Drinks.DrinkChoices drinkType = Order_Types.Drinks.DrinkChoices.NODRINK;
     public Entrees entreeType = Entrees.NOENTREE;

     public Proteins proteinType = Proteins.NOPROTEIN;

     public Customer_Inputs.Tortilla tortillaType = Customer_Inputs.Tortilla.NOTORTILLA;
     public sideChoices sideType = sideChoices.NOSIDE;
     public ArrayList<Customer_Inputs.Toppings> toppings = new ArrayList<>();

     Calculator mealCalculator = new Calculator();

    static double total = 0.00;


}
