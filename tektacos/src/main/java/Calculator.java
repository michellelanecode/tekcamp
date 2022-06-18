public class Calculator {


    double mealTotal;

    double toppingsTotal;

    double allTotal;
    Order currentOrder = CreateOrder.newOrder;
    public double calculateToppings() {
        double totalToppings = 0;
        for (Toppings i : currentOrder.toppings) {
           return totalToppings += i.cost;
        }
       return this.toppingsTotal = totalToppings;
    }

    public void calculateMeal(){
        this.mealTotal = currentOrder.entreeType.cost + currentOrder.proteinType.cost +currentOrder.tortillaType.cost + calculateToppings();
    }

    public void calculateTotal(){
        this.allTotal = Order.total += currentOrder.entreeType.cost + currentOrder.proteinType.cost + currentOrder.tortillaType.cost + currentOrder.sideType.cost + currentOrder.drinkType.cost + calculateToppings() ;

    }

}
