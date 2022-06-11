import java.util.Scanner;
public class Entree  {
    static Scanner sc = new Scanner(System.in);
    String entreeType;
    String tortillaType;
     String proteinType;
   String toppingChoice;



    public String getEntreeType() {
        System.out.println("What is your entree type? Basic, Deluxe, or Veggie");
       this.entreeType = sc.nextLine();
        System.out.println("What kind of tortilla would you like?");
       this.tortillaType = sc.nextLine();
        System.out.println("What kind of protein would you like?");
        this.proteinType = sc.nextLine();
        System.out.println("What toppings would you like?");
       this.toppingChoice = sc.nextLine();
       return this.returnOrder();
    }

    public String returnOrder(){
        return this.entreeType + " w/ " + this.proteinType + " & " + toppingChoice + " ";
    }
}
