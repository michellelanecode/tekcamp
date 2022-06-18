public class CustomerInfo {


    public String askForOrder(){
        System.out.println("Welcome to TEKTacos!");
        System.out.println("******** :-) :-) :-) :-) *******");
        System.out.println("Would you like an Entree(e), Combo(c), Drink(d), or Side(s)?");
        System.out.println("____________________________________________");
        return sc.nextLine();
    }

    public static String getEntreeChoice(){
        showEntreeMenu();
        System.out.println("What type of entree would you like? Basic(b), Deluxe(d), Veggie(v), CreateYourOwn (c)");
        return sc.nextLine();
    }

    public static String getTortilla(){
        System.out.println("What kind of tortilla would you like? Flour (f) or Corn (c)");
        return sc.nextLine();
    }

    public static String getProtein(){
        System.out.println("What kind of protein would you like? Beef(b), Chicken(c), Black Beans(bb), Shredded Pork(p), Steak(s)");
        return  sc.nextLine();
    }


    public static Boolean askForDeluxeToppings(){
        System.out.println("Does customer want standard toppings of lettuce, tomato, onion, cheese ? y or n");
        return sc.nextLine().equals("y");
    }

    public static String askForToppings(int toppingCount){
        System.out.println("What toppings would you like? You have " + toppingCount + " remaining");
        System.out.println("Toppings: Lettuce(l), Tomato(t), Cheese(cs), Salsa(s), Cilantro(ct), Jalapeno(j), Onion(o)");
        System.out.println(line);
        return sc.nextLine();
    }

    public static Boolean askForSide(){
        System.out.println("Would you like a side? y or n");
        return sc.nextLine().equals("y");
    }

    public static Boolean askForDrink(){
        System.out.println("Would you like a drink? y or n");
        return sc.nextLine().equals("y");
    }

}
