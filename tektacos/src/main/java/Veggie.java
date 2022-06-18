
public class Veggie extends Entree {


    public static void createEntree() {
        Order.entreeType = Entrees.VEGGIE;
        Entree.createEntree(4);
    }
}