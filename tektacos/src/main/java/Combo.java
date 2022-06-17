public class Combo extends Entree {
    String entreeType;
    String drinkChoice;
    String sideChoice;
    int cost = 7;

    @Override
    public String getEntreeType() {
       Entree newEntree = new Entree();
       this.entreeType = newEntree.getEntreeType();
       return this.entreeType;
    }

    public String getDrinkChoice() {
        Drinks newDrink = new Drinks();
        newDrink.getDrinkChoice();
        drinkChoice = newDrink.returnDrinkChoice();
        return this.drinkChoice;
    }

    public String getSideChoice(){
        Sides newSide = new Sides();
        newSide.getSide();
        sideChoice = newSide.returnSide();
        return this.sideChoice;
    }
    @Override
    public String returnOrder() {
        TekTacos.total += this.cost;
        return this.entreeType + ": w/ " + this.proteinType + " & " + this.toppingChoice + " " + this.cost;
    }
}
