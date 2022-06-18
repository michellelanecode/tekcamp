public class TekTacos {

    CustomerInfo currentCustomer = new CustomerInfo();
    CreateOrder currentRequest = new CreateOrder();
    Calculator currentCost = new Calculator();
    Receipt currentReceipt = new Receipt();



        public void main(String[] args) {
            String orderType = currentCustomer.askForOrder();
            currentRequest.createOrder(orderType);
            currentCost.calculateTotal();
            currentReceipt.returnReceipt();
    }
}
