import java.util.Scanner;
public class Entree  {
    static Scanner sc = new Scanner(System.in);
    String entreeType;
    String tortillaType;
     String proteinType;
   String toppingChoice;


    public Entree (String entreeType, String proteinType, String toppingChoice, String tortillaType) {
        this.entreeType = entreeType;
        this.proteinType = proteinType;
        this.toppingChoice = toppingChoice;
        this.tortillaType = tortillaType;
    }

    public String getEntreeType() {
        System.out.println("What is your entree type? Basic, Deluxe, or Veggie");
       entreeType = sc.nextLine();
        System.out.println("What kind of tortilla would you like?");
       tortillaType = sc.nextLine();
        System.out.println("What kind of protein would you like?");
        proteinType = sc.nextLine();
        System.out.println("What toppings would you like?");
       toppingChoice = sc.nextLine();
        return entreeType;
    }

    public String returnOrder(){
        return this.entreeType + " w/ " + this.proteinType + " & " + toppingChoice + " ";
    }
}
