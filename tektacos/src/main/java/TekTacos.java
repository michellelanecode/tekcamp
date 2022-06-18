import java.util.Scanner;

public class TekTacos {
      Scanner sc = new Scanner(System.in);

   String line = "____________________________";

     double total = 0;
    String comboMenu = "Combo includes Taco Entree Choice plus Toppings, Side and Drink";
   String proteinMenu = "Proteins: beef(b), chicken(c), steak(s), pork(p), black beans(bb) ";
    String toppingsMenu = "Lettuce(l), Tomato(t), Cheese(cs), Salsa(s), Cilantro(ct), Jalapeno(j), Onion(o)";
    public void showEntreeMenu(){
        System.out.println("Entree menu ");
        System.out.println("Basic - Tortilla (flour or corn) Protein ( and 4 toppings");
        System.out.println("Deluxe - Basic plus lettuce, tomato, onion, cheese and 2 additional toppings ");
        System.out.println("Veggie - Tortilla (flour or corn) Black beans and 4 toppings ");
        System.out.println(line);
        System.out.println("Proteins:");
        System.out.println(proteinMenu);
        System.out.println(line);
        System.out.println("Toppings menu:");
        System.out.println(toppingsMenu);
        System.out.println(line);
    }

        public void main(String[] args) {
            String orderType = askForOrder();
            createOrder(orderType);
            Order.calculateTotal();
            Receipt.returnReceipt();
    }
}
