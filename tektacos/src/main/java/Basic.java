import java.util.Scanner;

public class Basic extends Entree{
    static Scanner sc = new Scanner(System.in);
    String entreeType = "basic";
    String tortillaType = "flour";
    String proteinType = "beef";
    String toppingChoice;


    public void getToppingChoice() {
        System.out.println("What 4 toppings would you like?");
        this.toppingChoice =  sc.nextLine();
    }

    @Override
    public String returnOrder() {
        return this.entreeType + ": " + this.tortillaType + " " + this.proteinType + " w/ " + this.toppingChoice;
    }
}
