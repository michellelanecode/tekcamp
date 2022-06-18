public class Entree  {

    CreateOrder currentRequest = TekTacos.currentRequest;

    CustomerInfo currentCustomer = TekTacos.currentCustomer;
    public void createEntree(int toppingChoices) {
        String tortillaChoice = currentCustomer.getTortilla();
        currentRequest.chooseTortilla(tortillaChoice);
        String proteinChoice = currentCustomer.getProtein();
        currentRequest.chooseProtein(proteinChoice);
        while (toppingChoices > 0) {
            String toppingChoice = currentCustomer.askForToppings(toppingChoices);
            currentRequest.addToppings(toppingChoice);
            toppingChoices--;
        }
        if (currentCustomer.askForSide()) {
            currentRequest.createSide();
        } else {
            currentRequest.newOrder.sideType = Sides.sideChoices.NOSIDE;
        }

        if (currentCustomer.askForDrink()) {
            currentRequest.createDrink();
        } else {
            currentRequest.newOrder.drinkType = Drinks.DrinkChoices.NODRINK;
        }
    }

}
