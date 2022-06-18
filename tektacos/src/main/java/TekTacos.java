public class TekTacos {
    static CustomerInfo currentCustomer = new CustomerInfo();
    static CreateOrder currentRequest = new CreateOrder();
    static Calculator currentCost = new Calculator();
    static Receipt currentReceipt = new Receipt();

    public static void main(String[] args) {

        String orderType = currentCustomer.askForOrder();
        currentRequest.createOrder(orderType);
        currentCost.calculateTotal();
        currentReceipt.returnReceipt();

    }

}
