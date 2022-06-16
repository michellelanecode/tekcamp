import java.util.Scanner;

public class Basic extends Entree{
    static Scanner sc = new Scanner(System.in);
    String entreeType = "basic";
    String tortillaType = "flour";
    String proteinType = "beef";
    String toppingChoice = "Toppings:";

    int toppingChoicesRemaining = 4;

    public void getToppingChoice() {
        System.out.println("Enter topping choice. You have " + this.toppingChoicesRemaining + " left");
        this.toppingChoicesRemaining = this.toppingChoicesRemaining - 1;
        String choice = sc.nextLine();
        this.checkToppingChoices(choice);

        if (this.toppingChoicesRemaining > 0){
            this.getToppingChoice();
        }
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

    @Override
    public String returnOrder() {
        return this.entreeType + ": " + this.tortillaType + " " + this.proteinType + " w/ " + this.toppingChoice;
    }
}
