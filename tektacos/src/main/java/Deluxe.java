import java.util.Scanner;

public class Deluxe extends Entree{
    static Scanner sc = new Scanner(System.in);
    String entreeType = "DELUXE";
    String tortillaType = "TORTILLA: " + Tortilla.FLOUR;
    String proteinType = "PROTEIN: " + Proteins.STEAK;
    String toppingChoice ="TOPPINGS: " + Toppings.LETTUCE + " " + Toppings.ONION + " " + Toppings.TOMATO + " " + Toppings.CHEESE + " ";

   int toppingChoicesRemaining = 2;

int cost = 10;

   @Override
    public String getToppingChoice() {
       System.out.println("Toppings menu:");
       System.out.println("Lettuce(l), Tomato(t), Cheese(cs), Salsa(s), Cilantro(ct), Jalapeno(j), Onion(o)");
        System.out.println("Does customer want standard toppings of " + this.toppingChoice + " ? y or n");
        String answer = sc.nextLine();
        if (answer.equals("y")){
            while (this.toppingChoicesRemaining > 0){
                System.out.println("Choose additional toppings, you have " + this.toppingChoicesRemaining + " left");
                String choice = sc.nextLine();
                this.toppingChoicesRemaining--;
                this.checkToppingChoices(choice);
            }
        } else {
            this.toppingChoicesRemaining = 6;
            this.toppingChoice = "TOPPINGS: ";
            while (this.toppingChoicesRemaining > 0){
                System.out.println("Choose toppings, you have " + this.toppingChoicesRemaining + " left");
                String choice = sc.nextLine();
                this.toppingChoicesRemaining--;
                this.checkToppingChoices(choice);
            }
        }
        return this.toppingChoice;
    }

    @Override
    public void checkToppingChoices(String toppingChoice) {
        switch(toppingChoice){
            case "l":
                this.toppingChoice = this.toppingChoice + " " + Toppings.LETTUCE;
                TekTacos.total += Toppings.LETTUCE.cost;
                break;
            case "t":
                this.toppingChoice = this.toppingChoice + " " + Toppings.TOMATO;
                this.cost += Toppings.TOMATO.cost;
                break;
            case "o":
                this.toppingChoice = this.toppingChoice + " " + Toppings.ONION;
                this.cost += Toppings.ONION.cost;
                break;
            case "cs":
                this.toppingChoice = this.toppingChoice + " " + Toppings.CHEESE;
                this.cost += Toppings.CHEESE.cost;
                break;
            case "s":
                this.toppingChoice = this.toppingChoice + " " + Toppings.SALSA;
                this.cost += Toppings.SALSA.cost;
                break;
            case "ct":
                this.toppingChoice = this.toppingChoice + " " + Toppings.CILANTRO;
                this.cost += Toppings.CILANTRO.cost;
                break;
            case "j":
                this.toppingChoice = this.toppingChoice + " " + Toppings.JALEPENO;
                this.cost += Toppings.JALEPENO.cost;
                break;
        }
    }

    @Override
    public String returnOrder() {

       return this.entreeType + ": " + this.tortillaType + " " + this.proteinType + " w/ " + this.toppingChoice + " " + this.cost;
    }
}
