public class Receipt {
    Order currentOrder = CreateOrder.newOrder;
    public void returnReceipt() {
        System.out.println("____________________________________");
        System.out.println("Completing your order.....");
        System.out.println("____________________________________");
        System.out.println("** COPY RECEIPT******");
        System.out.println("****** TEKTACOS POS ******* ");
        System.out.println("____________________________________");
        System.out.println("1. ENTREE: " + currentOrder.entreeType + "TORTILLA: " + currentOrder.tortillaType + "TOPPINGS: " + currentOrder.toppings + " $" + currentOrder.mealTotal);
        System.out.println("2. SIDE: " + currentOrder.sideType + " $" + currentOrder.sideType.cost);
        System.out.println("3. DRINK: " + currentOrder.drinkType + " $" + currentOrder.drinkType.cost);
        System.out.println("____________________________________");
        System.out.println("Total:");
        System.out.println("$" + currentOrder.allTotal);
        System.out.println("____________________________________");
        System.out.println("THANKS FOR CHOOSING TEKTACOS");

    }
}
