import java.util.Scanner;
public class Entree  {
    static Scanner sc = new Scanner(System.in);
     String entreeType;
     String tortillaType;
     String proteinType;
     String toppingChoice = "TOPPINGS:";

     int toppingChoicesRemaining = 4;

    public String getEntreeType() {
        System.out.println("What is your entree type? basic, deluxe, veggie or cya");
       this.entreeType = sc.nextLine();

       if (entreeType.equals("basic")){
           Basic newBasic = new Basic();
           newBasic.getToppingChoice();
         return newBasic.returnOrder();

       } else if (entreeType.equals("deluxe")){
            Deluxe newDeluxe = new Deluxe();
            newDeluxe.getToppingChoice();
            return newDeluxe.returnOrder();
        } else if (entreeType.equals("veggie")){
           Veggie newVeggie = new Veggie();
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
                break;
            case "tomato":
                this.toppingChoice = this.toppingChoice + " " + Toppings.TOMATO;
                break;
            case "onion":
                this.toppingChoice = this.toppingChoice + " " + Toppings.ONION;
                break;
            case "cheese":
                this.toppingChoice = this.toppingChoice + " " + Toppings.CHEESE;
                break;
            case "salsa":
                this.toppingChoice = this.toppingChoice + " " + Toppings.SALSA;
                break;
            case "cilantro":
                this.toppingChoice = this.toppingChoice + " " + Toppings.CILANTRO;
                break;
            case "jalepeno":
                this.toppingChoice = this.toppingChoice + " " + Toppings.JALEPENO;
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
