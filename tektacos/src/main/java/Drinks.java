import java.util.Scanner;

public class Drinks {
    String drinkChoice;

    public String getDrinkChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What kind of drink would you like?");
        drinkChoice = sc.nextLine();
        return this.returnDrinkChoice();
    }
    public String returnDrinkChoice(){
        return this.drinkChoice;
    }
}
