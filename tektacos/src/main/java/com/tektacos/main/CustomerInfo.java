package com.tektacos.main;

import java.util.Scanner;

public class CustomerInfo {

    static Scanner sc = new Scanner(System.in);
    Menu menu = new Menu();
    public String askForOrder(){
        System.out.println("Welcome to TEKTacos!");
        System.out.println("******** :-) :-) :-) :-) *******");
        System.out.println("Would you like an Entree(e), Combo(c), Drink(d), or Side(s)?");
        System.out.println("____________________________________________");
        return sc.nextLine();
    }

    public String getEntreeChoice(){
        System.out.println(menu.comboMenu);
        System.out.println(menu.line);
        System.out.println(menu.entreeMenu);
        System.out.println(menu.line);
        System.out.println(menu.proteinMenu);
        System.out.println(menu.line);
        System.out.println(menu.toppingsMenu);
        System.out.println(menu.line);
        System.out.println("What type of entree would you like? Basic(b), Deluxe(d), Veggie(v), CreateYourOwn (c)");
        return sc.nextLine();
    }

    public String getTortilla(){
        System.out.println("What kind of tortilla would you like? Flour (f) or Corn (c)");
        return sc.nextLine();
    }

    public String getProtein(){
        System.out.println("What kind of protein would you like? Beef(b), Chicken(c), Black Beans(bb), Shredded Pork(p), Steak(s)");
        return  sc.nextLine();
    }


    public  Boolean askForDeluxeToppings(){
        System.out.println("Does customer want standard toppings of lettuce, tomato, onion, cheese ? y or n");
        return sc.nextLine().equals("y");
    }

    public String askForToppings(int toppingCount){
        System.out.println("What toppings would you like? You have " + toppingCount + " remaining");
        System.out.println(menu.toppingsMenu);
        System.out.println(menu.line);
        return sc.nextLine();
    }

    public Boolean askForSide(){
        System.out.println("Would you like a side? y or n");
        return sc.nextLine().equals("y");
    }

    public String getSideChoice(){
        System.out.println("Sides menu:");
        System.out.println("Sides menu: chips/queso (cq) | chips/salsa(cs) | fries (f)");
        System.out.println("What kind of side would you like?");
        return sc.nextLine();
    }
    public  Boolean askForDrink(){
        System.out.println("Would you like a drink? y or n");
        return sc.nextLine().equals("y");
    }

    public String getDrinkChoice(){
        System.out.println("Drinks menu:");
        System.out.println("Drink menu: water(w) | tea(t) | soda(s)");
        System.out.println("What kind of drink would you like?");
        return sc.nextLine();
    }
}
