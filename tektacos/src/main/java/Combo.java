public class Combo extends Entree {
    String drinkChoice;
    String sideChoice;
    @Override
    public String getEntreeType() {
        System.out.println("What is your entree type? Basic, Deluxe, or Veggie");
        this.entreeType = sc.nextLine();
        System.out.println("What kind of tortilla would you like?");
        this.tortillaType = sc.nextLine();
        System.out.println("What kind of protein would you like?");
        this.proteinType = sc.nextLine();
        System.out.println("What toppings would you like?");
        this.toppingChoice = sc.nextLine();
        System.out.println("What side would you like?");
        this.sideChoice = sc.nextLine();
        System.out.println("What drink would you like?");
        this.drinkChoice = sc.nextLine();
        return super.getEntreeType();
    }

    @Override
    public String returnOrder() {
        return this.entreeType + " w/ " + this.proteinType + " & " + toppingChoice + " Side: " + this.sideChoice + " Drink: " + this.drinkChoice;
    }
}
