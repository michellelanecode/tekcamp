public class TekTacos {

    static CustomerInfo currentCustomer = new CustomerInfo();
    static CreateOrder currentRequest = new CreateOrder();

    static Calculator currentCost = new Calculator();
    public static void main(String[] args) {
        String orderType = currentCustomer.askForOrder();
        currentRequest.createOrder(orderType);
        currentCost.calculateMeal();
        currentCost.calculateToppings();
        currentCost.calculateTotal();
        Receipt currentReceipt = new Receipt();
        currentReceipt.returnReceipt();
    }

}
