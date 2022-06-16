import java.util.Scanner;
public class Entree  {
    static Scanner sc = new Scanner(System.in);
     String entreeType;
     String tortillaType;
     String proteinType;
     String toppingChoice = "TOPPINGS:";

     int toppingChoicesRemaining = 4;

     double cost;
    public String getEntreeType() {
        System.out.println("What is your entree type? basic, deluxe, veggie or cya");
       this.entreeType = sc.nextLine();

       if (entreeType.equals("basic")){
           Basic newBasic = new Basic();
           this.cost = newBasic.cost;
           newBasic.getToppingChoice();
         return newBasic.returnOrder();

       } else if (entreeType.equals("deluxe")){
            Deluxe newDeluxe = new Deluxe();
           this.cost = newDeluxe.cost;
            newDeluxe.getToppingChoice();
            return newDeluxe.returnOrder();
        } else if (entreeType.equals("veggie")){
           Veggie newVeggie = new Veggie();
           this.cost = newVeggie.cost;
           newVeggie.getToppingChoice();
           return newVeggie.returnOrder();
       }
       return this.createEntree();
    }

    public String  getToppingChoice() {
        System.out.println("Enter topping choice. You have " + this.toppingChoicesRemaining + " left");
        this.toppingChoicesRemaining = this.toppingChoicesRemaining - 1;
        String choice = sc.nextLine();
        this.checkToppingChoices(choice);
        if (this.toppingChoicesRemaining > 0){
            this.getToppingChoice();
        }
        return this.toppingChoice;
    }

    public void checkToppingChoices(String toppingChoice){
        switch(toppingChoice){
            case "lettuce":
                this.toppingChoice = this.toppingChoice + " " + Toppings.LETTUCE;
                this.cost += Toppings.LETTUCE.cost;
                break;
            case "tomato":
                this.toppingChoice = this.toppingChoice + " " + Toppings.TOMATO;
                this.cost += Toppings.TOMATO.cost;
                break;
            case "onion":
                this.toppingChoice = this.toppingChoice + " " + Toppings.ONION;
                this.cost += Toppings.ONION.cost;
                break;
            case "cheese":
                this.toppingChoice = this.toppingChoice + " " + Toppings.CHEESE;
                this.cost += Toppings.CHEESE.cost;
                break;
            case "salsa":
                this.toppingChoice = this.toppingChoice + " " + Toppings.SALSA;
                this.cost += Toppings.SALSA.cost;
                break;
            case "cilantro":
                this.toppingChoice = this.toppingChoice + " " + Toppings.CILANTRO;
                this.cost += Toppings.CILANTRO.cost;
                break;
            case "jalepeno":
                this.toppingChoice = this.toppingChoice + " " + Toppings.JALEPENO;
                this.cost += Toppings.JALEPENO.cost;
                break;
        }
    }

    public String createEntree(){
        System.out.println("What kind of tortilla would you like?");
        this.tortillaType = sc.nextLine();
        System.out.println("What kind of protein would you like?");
        this.proteinType = sc.nextLine();
        System.out.println("What toppings would you like?");
        this.toppingChoice = sc.nextLine();
        return this.returnOrder();
    }

    public String returnOrder(){
        return this.entreeType + ": w/ " + this.proteinType + " & " + toppingChoice + " ";
    }
}
