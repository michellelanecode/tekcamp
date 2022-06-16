import java.util.Scanner;


public class Sides  {

    String side = "SIDE: ";

    public enum sideChoices {
        CHIPSANDQUESO,
        CHIPSANDSALSA,
        FRIES
    }

    public String getSide() {
        Scanner sc = new Scanner(System.in);
           System.out.println("What kind of side would you like?");
           String side = sc.nextLine();
         return  this.getSideEnum(side);
    }


    public String getSideEnum(String side){
        switch (side){
            case "cq":
                return this.side = this.side + sideChoices.CHIPSANDQUESO;

            case "cs":
                return this.side = this.side + sideChoices.CHIPSANDSALSA;

            case "f":
                return this.side = this.side + sideChoices.FRIES;

        }
        return  "NO CHOICE SELECTED";
    }
    public String returnSide(){
        return this.side;
    }
}
