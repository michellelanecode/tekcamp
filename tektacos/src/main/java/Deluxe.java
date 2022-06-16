import java.util.Scanner;

public class Deluxe extends Entree{
    static Scanner sc = new Scanner(System.in);
    String entreeType = "DELUXE";
    String tortillaType = "FLOUR";
    String proteinType = "STEAK";
    String toppingChoice ="LETTUCE TOMATO ONION CHEESE";

   int toppingChoicesRemaining = 2;

   @Override
    public String getToppingChoice() {
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
        super.checkToppingChoices(toppingChoice);
    }

    @Override
    public String returnOrder() {
        return this.entreeType + ": " + this.tortillaType + " " + this.proteinType + " w/ " + this.toppingChoice;
    }
}
