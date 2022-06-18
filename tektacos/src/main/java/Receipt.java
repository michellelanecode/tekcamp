public class Receipt {
    static double totalToppings;
    public void calculateTotal(){
        this.calculateToppings();
        Order.total += Order.entreeType.cost + Order.proteinType.cost + Order.tortillaType.cost + Order.sideType.cost + totalToppings;
    }

    public void calculateToppings() {
        for (Toppings i : Order.toppings) {
            this.totalToppings += i.cost;
        }
    }

    public static void returnReceipt() {
        System.out.println("____________________________________");
        System.out.println("Completing your order.....");
        System.out.println("____________________________________");
        System.out.println("** COPY RECEIPT******");
        System.out.println("****** TEKTACOS POS ******* ");
        System.out.println("____________________________________");
        System.out.println("1. " + Order.entreeType);
        System.out.println(" TORTILLA: " + Order.tortillaType);
        System.out.println("TOPPINGS: " + Order.toppings);
        System.out.println(Order.entreeType.cost + Order.tortillaType.cost + totalToppings);
        System.out.println("2. SIDE: " + Order.sideType + " $" + Order.sideType.cost);
        System.out.println("3. DRINK: " + Order.drinkType + " $" + Order.drinkType.cost);
        System.out.println("____________________________________");
        System.out.println("Total:");
        System.out.println("$" + Order.total);
        System.out.println("____________________________________");
        System.out.println("THANKS FOR CHOOSING TEKTACOS");

    }
}
