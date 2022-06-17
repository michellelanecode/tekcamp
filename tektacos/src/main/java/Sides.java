import java.util.Scanner;


public class Sides  {

    String side = "SIDE: ";
    int cost;
    public enum sideChoices {
        CHIPSANDQUESO(3),
        CHIPSANDSALSA(3),
        FRIES(2);

        public final int cost;

        sideChoices(int cost){
            this.cost = cost;
        }

    }

    public String getSide() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Sides menu:");
        System.out.println("Sides menu: chips/queso (cq) | chips/salsa(cs) | fries (f)");
           System.out.println("What kind of side would you like?");
           String side = sc.nextLine();
         return  this.getSideEnum(side);
    }


    public String getSideEnum(String side){
        switch (side){
            case "cq":
                this.cost += sideChoices.CHIPSANDQUESO.cost;
                return this.side = this.side + sideChoices.CHIPSANDQUESO;

            case "cs":
                this.cost += sideChoices.CHIPSANDSALSA.cost;
                return this.side = this.side + sideChoices.CHIPSANDSALSA;

            case "f":
                this.cost += sideChoices.FRIES.cost;
                return this.side = this.side + sideChoices.FRIES;

        }
        return  "NO CHOICE SELECTED";
    }
    public String returnSide(){
        TekTacos.total += this.cost;
        return this.side + " " + this.cost;
    }
}
