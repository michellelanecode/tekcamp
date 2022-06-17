import java.util.Scanner;

public class TekTacos {
     Scanner sc = new Scanner(System.in);

    static double total = 0;
     String comboMenu = "Combo includes Taco Entree Choice plus Toppings, Side and Drink";
    String proteinMenu = "Proteins: beef(b), chicken(c), steak(s), pork(p), black beans(bb) ";
     String toppingsMenu = "Lettuce(l), Tomato(t), Cheese(cs), Salsa(s), Cilantro(ct), Jalapeno(j), Onion(o)";

    public void showEntreeMenu(){
        System.out.println("Entree menu ");
        System.out.println("Basic - Tortilla (flour or corn) Protein ( and 4 toppings");
        System.out.println("Deluxe - Basic plus lettuce, tomato, onion, cheese and 2 additional toppings ");
        System.out.println("Veggie - Tortilla (flour or corn) Black beans and 4 toppings ");
        System.out.println("Proteins:");
        System.out.println(proteinMenu);
        System.out.println("Toppings menu:");
        System.out.println(toppingsMenu);

    }
    public String getOrder(){
        System.out.println("Welcome to TEKTacos!");
        System.out.println("******** :-) :-) :-) :-) *******");
        System.out.println("Would you like an Entree(e), Combo(c), Drink(d), or Side(s)?");
        return sc.nextLine();
    }
    public Boolean askForSide(){
        System.out.println("Would you like a side? y or n");
        if(sc.nextLine().equals("y")){
            return true;
        } else {
            return false;
        }
    }
    public Boolean askForDrink(){
        System.out.println("Would you like a drink? y or n");
        if(sc.nextLine().equals("y")){
            return true;
        } else {
            return false;
        }
    }
    void createDrink(){
        System.out.println("Drinks menu:");
        System.out.println("Drink menu: water(w) | tea(t) | soda(s)");
        System.out.println("What kind of drink would you like?");
        String choice = sc.nextLine();
        Drinks newDrink = new Drinks();
        Order.drinkType = newDrink.returnDrinkChoice(choice);
    }
    public void createSide (){
        System.out.println("Sides menu:");
        System.out.println("Sides menu: chips/queso (cq) | chips/salsa(cs) | fries (f)");
        System.out.println("What kind of side would you like?");
        String side = sc.nextLine();
        Sides newSide = new Sides();
        Order.sideType = newSide.returnSide(side);
    }
    public void createEntree(){
        showEntreeMenu();
        Entree newEntree = new Entree();
        Order.entreeType = newEntree.getEntreeType();
        TekTacos.total += newEntree.cost;
    }
    public void createCombo(){
        System.out.println(comboMenu);
        Combo newCombo = new Combo();
        entreeType =  newCombo.getEntreeType();
        drinkType =  newCombo.getDrinkChoice();
        sideType =  newCombo.getSideChoice();
    }
    public void createOrder(String orderType){
        switch (orderType) {
            case "e":
                createEntree();
                askForSide();
                createSide();
                askForDrink();
                createDrink();
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

}
