import java.util.Scanner;

public class Veggie extends Basic {
    static Scanner sc = new Scanner(System.in);
    String tortillaType = "corn";
    String proteinType = "black beans";
    String toppingChoice;

    public void getToppingChoice() {
       super.getToppingChoice();
    }
    @Override
    public String returnOrder() {
        return this.entreeType + ": " + this.tortillaType + " " + this.proteinType + " w/ " + this.toppingChoice;
    }
}