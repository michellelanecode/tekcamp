public class Entree  {

    public enum Entrees {
        BASIC(5.00),
        DELUXE(8.00),
        VEGGIE(4.50),
        CYA(5.00);



        public final double cost;

        Entrees(double cost) {
            this.cost = cost;
        }

    }

    public void createEntree(int toppingChoices) {
        String tortillaChoice = TekTacos.getTortilla();
        TekTacos.chooseTortilla(tortillaChoice);
        String proteinChoice = TekTacos.getProtein();
        TekTacos.chooseProtein(proteinChoice);
        while (toppingChoices > 0) {
            String toppingChoice = TekTacos.askForToppings(toppingChoices);
            TekTacos.addToppings(toppingChoice);
        }
        if (TekTacos.askForSide()) {
            TekTacos.createSide();
        }

        if (TekTacos.askForDrink()) {
            TekTacos.createDrink();
        }
    }

}
