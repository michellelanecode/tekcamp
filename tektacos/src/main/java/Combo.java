public class Combo extends Entree {

    double cost = 7.00;

    @Override
    public String getEntreeType() {
       Entree newEntree = new Entree();
       Order.entreeType = newEntree.getEntreeType();
       return this.entreeType;
    }

    public Drinks.DrinkChoices getDrinkChoice() {
        if(TekTacos.askForDrink()){
            TekTacos.createDrink();
        }

        return Order.drinkType = Drinks.DrinkChoices.NODRINK;
    }

    public Sides.sideChoices getSideChoice(){
        if(TekTacos.askForSide()){
            TekTacos.createSide();
        }

          return Order.sideType = Sides.sideChoices.NOSIDE;

    }
    @Override
    public String returnOrder() {
        TekTacos.total += this.cost;
        return this.entreeType + ": w/ " + this.proteinType + " & " + this.toppingChoice;
    }
}
