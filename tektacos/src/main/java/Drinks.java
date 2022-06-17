import java.util.Scanner;

public class Drinks {
    String drinkChoice = "DRINK: ";
double cost;
    public enum DrinkChoices {
        SODA(5),
        TEA(1),
        WATER(0);

        public final int cost;

        DrinkChoices(int cost){
            this.cost = cost;
        }

    }

    public String getDrinkChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Drinks menu:");
        System.out.println("Drink menu: water(w) | tea(t) | soda(s)");
        System.out.println("What kind of drink would you like?");
        String drink = sc.nextLine();
       return this.getDrinkEnum(drink);
    }

    public String getDrinkEnum(String drink){
        switch (drink){
            case "s":
                this.cost += DrinkChoices.SODA.cost;
                return this.drinkChoice = this.drinkChoice + DrinkChoices.SODA;

            case "t":
                this.cost += DrinkChoices.TEA.cost;
                return  this.drinkChoice = this.drinkChoice + DrinkChoices.TEA;

            case "w":
                this.cost += DrinkChoices.WATER.cost;
                return this.drinkChoice = this.drinkChoice + DrinkChoices.WATER;

        }
        return  "NO CHOICE SELECTED";
    }
    public String returnDrinkChoice(){
        TekTacos.total += this.cost;
        return this.drinkChoice + " " + this.cost;
    }
}
