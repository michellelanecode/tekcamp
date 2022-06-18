public class Entree  {

    CreateOrder currentRequest = TekTacos.currentRequest;
    public static void createEntree(int toppingChoices) {
        String tortillaChoice = CreateOrder.getTortilla();
        TekTacos.chooseTortilla(tortillaChoice);
        String proteinChoice = TekTacos.getProtein();
        TekTacos.chooseProtein(proteinChoice);
        while (toppingChoices > 0) {
            String toppingChoice = TekTacos.askForToppings(toppingChoices);
            TekTacos.addToppings(toppingChoice);
            toppingChoices--;
        }
        if (TekTacos.askForSide()) {
            TekTacos.createSide();
        } else {
            Order.sideType = Sides.sideChoices.NOSIDE;
        }

        if (TekTacos.askForDrink()) {
            TekTacos.createDrink();
        } else {
            Order.drinkType = Drinks.DrinkChoices.NODRINK;
        }
    }

}
