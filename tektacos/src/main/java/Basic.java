public class Basic extends Entree{

   double cost = 5.00;

   int toppingChoicesRemaining = 4;


    public void createEntree(){
        Order.entreeType = "BASIC";
        super.createEntree(this.toppingChoicesRemaining);
    }



}
