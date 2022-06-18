public class Calculator {
    Order currentOrder = CreateOrder.newOrder;
    public double calculateToppings() {
        double totalToppings = 0;


        for (Toppings i : currentOrder.toppings) {
           return totalToppings += i.cost;
        }
       return totalToppings;
    }

    public double calculateMeal(){
        return currentOrder.entreeType.cost + currentOrder.proteinType.cost +currentOrder.tortillaType.cost + calculateToppings();
    }

    public double calculateTotal(){

     return  Order.total += currentOrder.entreeType.cost + currentOrder.proteinType.cost + currentOrder.tortillaType.cost + currentOrder.sideType.cost + currentOrder.drinkType.cost + calculateToppings() ;

    }

}
