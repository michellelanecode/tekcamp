import java.util.Scanner;
public class Entree  {
    static Scanner sc = new Scanner(System.in);
     String entreeType ="ENTREE: ";
     String tortillaType ="TORTILLA: ";
     String proteinType ="PROTEIN: ";
     String toppingChoice ="TOPPINGS: ";

     int toppingChoicesRemaining = 4;

     double cost = 0.00;
    public String getEntreeType() {
        System.out.println("What is your entree type? basic(b), deluxe(d), veggie(v) or create your own (cya)");
       this.entreeType = sc.nextLine();

        switch (entreeType) {
            case "b":
                Basic newBasic = new Basic();
                this.cost += newBasic.cost;
                newBasic.getToppingChoice();
                return newBasic.returnOrder();
            case "d":
                Deluxe newDeluxe = new Deluxe();
                this.cost += newDeluxe.cost;
                newDeluxe.getToppingChoice();
                return newDeluxe.returnOrder();
            case "v":
                Veggie newVeggie = new Veggie();
                this.cost += newVeggie.cost;
                newVeggie.getToppingChoice();
                return newVeggie.returnOrder();
        }
       return this.createEntree();
    }

    public String  getToppingChoice() {
        System.out.println("Toppings menu:");
        System.out.println("Lettuce(l), Tomato(t), Cheese(cs), Salsa(s), Cilantro(ct), Jalapeno(j), Onion(o)");
        System.out.println("Enter topping choice. You have " + this.toppingChoicesRemaining + " left");
        String choice = sc.nextLine();
        this.checkToppingChoices(choice);
        this.toppingChoicesRemaining--;
        if (this.toppingChoicesRemaining > 0){
            this.getToppingChoice();

        }
        return this.toppingChoice;
    }

    public void checkToppingChoices(String toppingChoice){
        switch(toppingChoice){
            case "l":
                this.toppingChoice = this.toppingChoice + " " + Toppings.LETTUCE;
                this.cost += Toppings.LETTUCE.cost;
                break;
            case "t":
                this.toppingChoice = this.toppingChoice + " " + Toppings.TOMATO;
                this.cost += Toppings.TOMATO.cost;
                break;
            case "o":
                this.toppingChoice = this.toppingChoice + " " + Toppings.ONION;
                this.cost += Toppings.ONION.cost;
                break;
            case "cs":
                this.toppingChoice = this.toppingChoice + " " + Toppings.CHEESE;
                this.cost += Toppings.CHEESE.cost;
                break;
            case "s":
                this.toppingChoice = this.toppingChoice + " " + Toppings.SALSA;
                this.cost += Toppings.SALSA.cost;
                break;
            case "ct":
                this.toppingChoice = this.toppingChoice + " " + Toppings.CILANTRO;
                this.cost += Toppings.CILANTRO.cost;
                break;
            case "j":
                this.toppingChoice = this.toppingChoice + " " + Toppings.JALEPENO;
                this.cost += Toppings.JALEPENO.cost;
                break;
        }

    }

    public String createEntree(){
        System.out.println("What kind of tortilla would you like?");
        String tortilla = sc.nextLine();
        this.tortillaType += this.getTortilla(tortilla);

        System.out.println("What kind of protein would you like?");
        String protein = sc.nextLine();
        this.proteinType += this.getProtein(protein);
        this.getToppingChoice();
        return this.returnOrder();
    }

    public Proteins getProtein(String protein){
        switch (protein){
            case "b":
                this.cost += Proteins.BEEF.cost;
                return Proteins.BEEF;
            case "s":
                this.cost += Proteins.STEAK.cost;
                return Proteins.STEAK;

            case "c":
                this.cost += Proteins.CHICKEN.cost;
                return Proteins.CHICKEN;

            case "sp":
                this.cost += Proteins.SHREDDEDPORK.cost;
                return Proteins.SHREDDEDPORK;

            case "bb":
                this.cost += Proteins.BLACKBEANS.cost;
                return Proteins.BLACKBEANS;
        }
        this.cost += Proteins.BEEF.cost;
        return Proteins.BEEF;
    }
    public Tortilla getTortilla(String tortilla) {
        if (tortilla.equals("f")){
            this.cost += Tortilla.FLOUR.cost;
            return Tortilla.FLOUR;
        } else{
            this.cost += Tortilla.CORN.cost;
            return Tortilla.CORN;
        }
    }
    public String returnOrder(){
        TekTacos.total += this.cost;
        return this.entreeType + ": w/ " + this.proteinType + " & " + this.toppingChoice + " " + this.cost;
    }
}
