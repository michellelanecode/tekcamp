public class Calculator {
    public double calculateToppings() {
        double totalToppings = 0;
        Order newOrder = new Order();
        for (Toppings i : newOrder.toppings) {
           return totalToppings += i.cost;
        }
       return totalToppings;
    }

    public double calculateMeal(){
        Order newOrder = new Order();
        return newOrder.entreeType.cost + newOrder.proteinType.cost + newOrder.tortillaType.cost + calculateToppings();
    }

    public double calculateTotal(){
        Order newOrder = new Order();
     return  Order.total += newOrder.entreeType.cost + newOrder.proteinType.cost + newOrder.tortillaType.cost + newOrder.sideType.cost + newOrder.drinkType.cost + calculateToppings() ;

    }

}
