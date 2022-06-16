import java.util.Scanner;

public class Veggie extends Basic {
    static Scanner sc = new Scanner(System.in);

    String entreeType = "VEGGIE";
    String tortillaType = "CORN";
    String proteinType = "BLACK BEANS";
    String toppingChoice = "TOPPINGS:";

    @Override
    public String getToppingChoice() {
      return this.toppingChoice = super.getToppingChoice();
    }

    @Override
    public String returnOrder() {
        return this.entreeType + ": " + this.tortillaType + " " + this.proteinType + " w/ " + this.toppingChoice;
    }
}