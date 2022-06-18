public class TekTacos {

    static CustomerInfo currentCustomer = new CustomerInfo();
    static CreateOrder currentRequest = new CreateOrder();
    Calculator currentCost = new Calculator();
    Receipt currentReceipt = new Receipt();



        public void main(String[] args) {
            String orderType = currentCustomer.askForOrder();
            currentRequest.createOrder(orderType);
            currentCost.calculateTotal();
            currentReceipt.returnReceipt();
    }
}
