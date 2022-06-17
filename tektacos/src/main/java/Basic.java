import java.util.Scanner;

public class Basic extends Entree{
    static Scanner sc = new Scanner(System.in);
    String entreeType = "BASIC";
    String tortillaType = "FLOUR";
    String proteinType = "BEEF";
    String toppingChoice;

   double cost = 5.00;

    int toppingChoicesRemaining = super.toppingChoicesRemaining;

    @Override
    public String getToppingChoice() {
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

    @Override
    public void checkToppingChoices(String toppingChoice) {
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

    @Override
    public String returnOrder() {
        TekTacos.total += this.cost;
        return this.entreeType + ": " + this.tortillaType + " " + this.proteinType + " w/ " + this.toppingChoice + " $" + this.cost;
    }
}
