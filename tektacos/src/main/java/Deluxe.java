

public class Deluxe extends Entree{

   int toppingChoicesRemaining = 2;

    int cost = 10;


    public void createEntree() {
        Order.entreeType = "DELUXE";
        super.createEntree(this.toppingChoicesRemaining);
    }
}
