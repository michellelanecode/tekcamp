import java.util.Scanner;

public class Deluxe extends Entree{
    static Scanner sc = new Scanner(System.in);
    String tortillaType = "flour";
    String proteinType = "steak";
    String toppingChoice ="lettuce tomato onion cheese";
    public void getToppingChoice() {
        System.out.println("Choose two toppings?");
        this.toppingChoice = this.toppingChoice + " " + sc.nextLine();
    }
    @Override
    public String returnOrder() {
        return this.entreeType + ": " + this.tortillaType + " " + this.proteinType + " w/ " + this.toppingChoice;
    }
}
