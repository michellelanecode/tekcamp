public class Combo extends Entree {
    String drinkChoice;
    String sideChoice;
    @Override
    public String getEntreeType() {
       return super.getEntreeType();
    }

    public String getDrinkChoice() {
        Drinks newDrink = new Drinks();
        drinkChoice = newDrink.getDrinkChoice();
        return this.drinkChoice;
    }

    public String getSideChoice(){
        Sides newSide = new Sides();
        sideChoice = newSide.getSide();
        return this.sideChoice;
    }
    @Override
    public String returnOrder() {
        return super.returnOrder();
    }
}
