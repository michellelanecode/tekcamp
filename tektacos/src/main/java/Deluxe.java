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

    }

    @Override
    public String returnOrder() {
       TekTacos.total += this.cost;
       return this.entreeType + ": " + this.tortillaType + " " + this.proteinType + " w/ " + this.toppingChoice;
    }
}
