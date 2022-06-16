import java.util.Scanner;


public class Sides  {

    String side = "SIDE: ";

    public String getSide() {
        Scanner sc = new Scanner(System.in);
           System.out.println("What kind of side would you like?");
           this.side = sc.nextLine();
         return  this.returnSide();
    }
    public String returnSide(){
        return this.side;
    }
}
