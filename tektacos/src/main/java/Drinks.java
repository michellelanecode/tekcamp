import java.util.Scanner;

public class Drinks {
    String drinkChoice = "DRINK: ";

    public enum DrinkChoices {
        SODA,
        TEA,
        WATER
    }

    public void getDrinkChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What kind of drink would you like?");
        String drink = sc.nextLine();
         this.getDrinkEnum(drink);
    }

    public void getDrinkEnum(String drink){
        switch (drinkChoice){
            case "soda":
                this.drinkChoice = this.drinkChoice + DrinkChoices.SODA;
                break;
            case "tea":
                this.drinkChoice = this.drinkChoice + DrinkChoices.TEA;
                break;
            case "water":
                this.drinkChoice = this.drinkChoice + DrinkChoices.WATER;
                break;
        }
    }
    public String returnDrinkChoice(){
        return this.drinkChoice;
    }
}
