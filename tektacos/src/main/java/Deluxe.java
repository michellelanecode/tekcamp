import java.util.Scanner;

public class Deluxe extends Entree{
    static Scanner sc = new Scanner(System.in);
    String entreeType = "deluxe";
    String tortillaType = "flour";
    String proteinType = "steak";
    String toppingChoice ="lettuce tomato onion cheese";

   int toppingChoicesRemaining = 2;
    public void getToppingChoice() {
        System.out.println("Does customer want standard toppings? y or n");
        String answer = sc.nextLine();

        if (answer.equals("y")){
            System.out.println("Choose additional toppings, you have " + this.toppingChoicesRemaining + " left");
        }

        this.toppingChoice = this.toppingChoice + " " + sc.nextLine();
    }
    @Override
    public String returnOrder() {
        return this.entreeType + ": " + this.tortillaType + " " + this.proteinType + " w/ " + this.toppingChoice;
    }
}
