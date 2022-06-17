public class Drinks {
    public enum DrinkChoices {
        SODA(5.00),
        TEA(1.50),
        WATER(1.00);

        public final double cost;

        DrinkChoices(double cost){
            this.cost = cost;
        }

    }
    public DrinkChoices returnDrinkChoice(String drink){
        switch (drink){
            case "s":
                return  DrinkChoices.SODA;

            case "t":
                return   DrinkChoices.TEA;

            case "w":
                return DrinkChoices.WATER;
        }
        return  DrinkChoices.WATER;
    }
}
