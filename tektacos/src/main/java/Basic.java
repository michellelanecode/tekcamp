import java.util.Scanner;

public class Basic extends Entree{
    static Scanner sc = new Scanner(System.in);
    String entreeType = "BASIC";
    String tortillaType = "FLOUR";
    String proteinType = "BEEF";
    String toppingChoice = super.toppingChoice;

    double cost = 5.75;

    int toppingChoicesRemaining = super.toppingChoicesRemaining;

    @Override
    public String getToppingChoice() {
      return this.toppingChoice = super.getToppingChoice();
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
