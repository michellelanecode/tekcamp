import java.util.Scanner;

public class Drinks {
    String drinkChoice = "DRINK: ";

    public enum DrinkChoices {
        SODA,
        TEA,
        WATER
    }

    public String getDrinkChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What kind of drink would you like?");
        String drink = sc.nextLine();
       return this.getDrinkEnum(drink);
    }

    public String getDrinkEnum(String drink){
        switch (drinkChoice){
            case "soda":
                return this.drinkChoice = this.drinkChoice + DrinkChoices.SODA;

            case "tea":
                return  this.drinkChoice = this.drinkChoice + DrinkChoices.TEA;

            case "water":
                return this.drinkChoice = this.drinkChoice + DrinkChoices.WATER;

        }
        return  "NO CHOICE SELECTED";
    }
    public String returnDrinkChoice(){
        return this.drinkChoice;
    }
}
