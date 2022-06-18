public class Veggie extends Entree {

    public void createEntree() {
        CreateOrder.newOrder.entreeType = Entrees.VEGGIE;
        Entree newVeggie = new Entree();
        newVeggie.createEntree(4);
    }
}