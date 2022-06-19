package com.tektacos.main;
import com.tektacos.financial.Calculator;
import com.tektacos.financial.Receipt;

public class TekTacos {

    public static CustomerInfo currentCustomer = new CustomerInfo();
    public static CreateOrder currentRequest = new CreateOrder();

    public static Calculator currentCost = new Calculator();
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
