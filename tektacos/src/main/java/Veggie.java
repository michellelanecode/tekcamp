public class Veggie extends Entree {


    public static void createEntree() {
        CreateOrder.newOrder.entreeType = Entrees.VEGGIE;
        Entree newVeggie = new Entree();
        newVeggie.createEntree(4);
    }
}