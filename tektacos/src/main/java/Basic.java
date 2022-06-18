public class Basic extends Entree{
    public void createEntree(){
        CreateOrder.newOrder.entreeType =  Entrees.BASIC;
        Entree newBasic = new Entree();
        newBasic.createEntree(4);
    }

}
