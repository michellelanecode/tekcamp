public class TekTacos {

    static CustomerInfo currentCustomer = new CustomerInfo();
    static CreateOrder currentRequest = new CreateOrder();
    public static void main(String[] args) {


        String orderType = currentCustomer.askForOrder();
        currentRequest.createOrder(orderType);
        Calculator currentCost = new Calculator();
        currentCost.calculateTotal();
        Receipt currentReceipt = new Receipt();
        currentReceipt.returnReceipt();

    }

}
